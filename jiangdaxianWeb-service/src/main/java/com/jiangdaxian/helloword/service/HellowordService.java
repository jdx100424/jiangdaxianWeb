package com.jiangdaxian.helloword.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiangdaxian.helloword.api.HellowordApi;
import com.jiangdaxian.kafka.BaseProducer;
import com.jiangdaxian.kafka.dto.MessageDto;

@Service
public class HellowordService {
	@Autowired
	private HellowordApi hellowordApi;
	
	@Autowired
	private BaseProducer<Calendar> hellowordProducer;
	
	public String get() {
		String dubboApi = hellowordApi.sayHello();
		return "jdxTest:"+System.currentTimeMillis() +","+dubboApi;
	}
	
	public void sendKafka() {
		hellowordProducer.send("jdxHellowordKafka", Calendar.getInstance());
	}
}
