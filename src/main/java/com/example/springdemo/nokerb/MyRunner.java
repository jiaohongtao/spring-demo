package com.example.springdemo.nokerb;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 测试消息生产者与消息消费者
 *
 * @author JustryDeng
 * @date 2019/2/15 12:35
 */
@Component
public class MyRunner implements ApplicationRunner {

    private final MyProducer myProducer;

    public MyRunner(MyProducer myProducer) {
        this.myProducer = myProducer;
    }

    @Override
    public void run(ApplicationArguments args) {
        int count = 3;
        for (int i = 0; i < count; i++) {
            myProducer.sendMessage("我是消息, 我被发送出去啦！" + i + "\n");
        }
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}