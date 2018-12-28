package com.sample.appops.util;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.appops.model.value.EmailVO;

public class EmailVODeserializer implements Deserializer<EmailVO> {


	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmailVO deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		EmailVO response = null;
	    try {
	    	response = mapper.readValue(data, EmailVO.class);
	    } catch (Exception e) {
	 
	      e.printStackTrace();
	    }
	    return response;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}


}
