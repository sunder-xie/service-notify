package com.faker.notify.component.queue;

import com.alibaba.fastjson.JSONObject;
import com.faker.notify.model.queue.Action;
import com.faker.notify.model.queue.Message;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by faker on 17/5/26.
 */
@Component
public class KafkaReceiver extends KafkaBase {

    private static final Logger logger = LogManager.getLogger(KafkaReceiver.class);

    private KafkaConsumer<String, String> consumer;

    private ConcurrentHashMap<String, ConsumerListener> listenerMap = new ConcurrentHashMap<>();

    private Properties config;

    @PostConstruct
    public void init() {
        consumer = new KafkaConsumer<String, String>(this.config);
        String topic = super.getTopic();
        Runnable consumeTask = new Runnable() {
            @Override
            public void run() {
                consumer.subscribe(Arrays.asList(topic));
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(100);
                    if (records != null) {
                        consume(records);
                    }
                }
            }
        };
        Thread workThread = new Thread(consumeTask);
        workThread.start();
    }

    private void consume(ConsumerRecords<String, String> records) {
        records.forEach(record -> {
            try {
                Message message = JSONObject.parseObject(record.value(), Message.class);
                Action action = listenerMap.get(message.getTag()).doConsume(message);
                switch (action) {
                    case Resume:
                        logger.warn("该笔消息消费失败,key:{}", message.getKey());
                        break;
                }
            } catch (Exception e) {
                consumer.commitSync();
                logger.error("kafka消费过程发生异常", e);
            }
        });
        consumer.commitSync();
    }

    public Properties getConfig() {
        return config;
    }

    public void setConfig(Properties config) {
        this.config = config;
    }

    public ConcurrentHashMap<String, ConsumerListener> getListenerMap() {
        return listenerMap;
    }

    public void setListenerMap(ConcurrentHashMap<String, ConsumerListener> listenerMap) {
        this.listenerMap = listenerMap;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (consumer != null) {
            consumer.close();
        }
    }

}
