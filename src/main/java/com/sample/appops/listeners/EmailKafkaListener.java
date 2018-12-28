package com.sample.appops.listeners;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import com.sample.appops.model.value.EmailVO;

@Component
public class EmailKafkaListener implements SmartLifecycle {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailKafkaListener.class);

    
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Autowired
    private KafkaConsumer<String, EmailVO> emailKafkaTopicConsumer;

    private volatile boolean running = false;
   
    @Override
    public void start() {
    	//TODO: Read Server.properties here.
        EmailConsumer emailConsumer = new EmailConsumer(this.emailKafkaTopicConsumer);
        executorService.submit(emailConsumer);
        this.running = true;
    }

    @Override
    public void stop() {
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {

    }

    @Override
    public int getPhase() {
        return 0;
    }
}