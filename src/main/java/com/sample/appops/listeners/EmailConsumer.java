package com.sample.appops.listeners;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.appops.model.value.EmailVO;

public class EmailConsumer implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(EmailConsumer.class);

    private final KafkaConsumer<String, EmailVO> emailConsumer;

    public EmailConsumer(KafkaConsumer<String, EmailVO> emailConsumer) {
        this.emailConsumer = emailConsumer;
    }

    public void run() {
        try {
            while (true) {
                ConsumerRecords<String, EmailVO> records = this.emailConsumer.poll(100);
                for (ConsumerRecord<String, EmailVO> record : records) {
                    log.info("consuming from topic = {}, partition = {}, ts = {}, ts-type = {},  offset = {}, key = {}, value = {}",
                            record.topic(), record.partition(), record.timestamp(), record.timestampType(), record.offset(), record.key(), record.value());

                }
            }
        } finally {
            this.emailConsumer.close();
        }
    }
}