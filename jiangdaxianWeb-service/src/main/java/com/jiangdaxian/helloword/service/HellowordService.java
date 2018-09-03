package com.jiangdaxian.helloword.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HellowordService {

	/**
	@Autowired
	@Qualifier("hellowordProducer")
	private com.jiangdaxian.kafka.BaseProducer<Calendar> hellowordProducer;*/
	
	public String get() {
		
		return "jdxTest:"+System.currentTimeMillis() ;
	}
	
	public void sendKafka() {
		//hellowordProducer.send("aaaaaaaa", Calendar.getInstance());
	}
}
