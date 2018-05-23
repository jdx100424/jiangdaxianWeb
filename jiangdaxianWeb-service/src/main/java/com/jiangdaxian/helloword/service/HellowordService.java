package com.jiangdaxian.helloword.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiangdaxian.helloword.api.HellowordApi;

@Service
public class HellowordService {
	@Autowired
	private HellowordApi hellowordApi;
	
	public String get() {
		String dubboApi = hellowordApi.sayHello();
		
		return "jdxTest:"+System.currentTimeMillis() +","+dubboApi;
	}
}
