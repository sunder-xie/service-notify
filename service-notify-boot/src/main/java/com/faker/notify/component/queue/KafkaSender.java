package com.faker.notify.component.queue;

import com.alibaba.fastjson.JSON;
import com.faker.notify.model.queue.Message;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * Created by faker on 17/5/26.
 */
@Component
public class KafkaSender extends KafkaBase {

    private static final Logger logger = LogManager.getLogger(KafkaSender.class);

    private KafkaProducer<String, String> producer;

    private Properties config;

    @PostConstruct
    public void init() {
        producer = new KafkaProducer<String, String>(this.config);
    }

    public String send(Message message) {
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(super.getTopic(), message.getKey(), JSON.toJSONString(message.getData()));
        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception e) {
                if (e != null) {
                    logger.error("kafka推送消息发生异常", e);
                    if (metadata != null) {
                        logger.info("The offset of the record we just sent is: " + metadata.offset());
                    }
                }
            }
        });
        return message.getKey();
    }

    public Properties getConfig() {
        return config;
    }

    public void setConfig(Properties config) {
        this.config = config;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (producer != null) {
            producer.close();
        }
    }
}
