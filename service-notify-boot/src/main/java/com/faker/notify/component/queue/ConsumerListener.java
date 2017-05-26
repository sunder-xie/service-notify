package com.faker.notify.component.queue;

import com.faker.notify.model.queue.Action;
import com.faker.notify.model.queue.Message;

/**
 * Created by faker on 17/5/26.
 */
public interface ConsumerListener {
    Action doConsume(Message message);
}
