package com.sample.appops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.appops.config.KafkaService;
import com.sample.appops.model.value.EmailVO;

@Controller
@RequestMapping("/")
public class HelloWorldController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 3 MVC");
		return "welcome";
	}


	@RequestMapping(value="/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome";
	}

	@Autowired
    private KafkaService kafkaService;

    @RequestMapping(value = "/publish/{topic}/{emailVO}", method = RequestMethod.GET)
	@ResponseBody
    public boolean sendMessage(@PathVariable String topic,@PathVariable String emailVO) {
    	EmailVO email=new EmailVO();
    	email.setToAddress(emailVO);
        return this.kafkaService.publishEmail(topic, email);
    }
}
