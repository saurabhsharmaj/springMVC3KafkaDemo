package com.sample.appops.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.appops.model.value.EmailVO;

@Service
public class KafkaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaService.class);
	
	@Autowired
    private KafkaProducer<String, EmailVO> kafkaTopicProducer;
	
	 public boolean publishEmail(String topic, EmailVO emailVO) {
	        ProducerRecord<String, EmailVO> record =
	                new ProducerRecord<String, EmailVO>(topic, emailVO);
	        try {
	            RecordMetadata recordMetadata = this.kafkaTopicProducer.send(record).get();
	            LOGGER.info("topic = {}, partition = {}, offset = {}, workUnit = {}",
	                    recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), emailVO);
	            return true;
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
