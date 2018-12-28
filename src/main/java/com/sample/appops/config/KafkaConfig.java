package com.sample.appops.config;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.sample.appops.model.value.EmailVO;
import com.sample.appops.util.EmailVODeserializer;

@Configuration
public class KafkaConfig {

    @Bean
    public KafkaConsumer<String, EmailVO> emailKafkaTopicConsumer(KafkaConfigProperties kafkaConsumerProperties) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "Saurabh_LOCAL");
        props.put("auto.offset.reset", "earliest");
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, EmailVO> consumer = new KafkaConsumer<String, EmailVO>(props,stringKeyDeserializer(),new EmailVODeserializer());
        consumer.subscribe(Collections.singletonList("bars"));
        return consumer;
    }

    @Bean
    public Deserializer stringKeyDeserializer() {
        return new StringDeserializer();
    }
    
    @Bean
    public Deserializer workUnitJsonValueDeserializer() {
        return new JsonDeserializer(EmailVO.class);
    }
    
    
    @Bean
    public KafkaProducer<String, EmailVO> kafkaTopicProducer(KafkaConfigProperties kafkaProducerProperties) {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");
//        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, EmailVO> producer = new KafkaProducer<String, EmailVO>(kafkaProps,stringKeySerializer(),
        		emailJsonSerializer());
        return producer;
    }

    @Bean
    public Serializer stringKeySerializer() {
        return new StringSerializer();
    }

    @Bean
    public Serializer emailJsonSerializer() {
        return new JsonSerializer();
    }
    
    
}