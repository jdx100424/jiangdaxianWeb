package com.jiangdaxian.helloword.service;

import org.springframework.stereotype.Service;

@Service
public class HellowordService {
	public String get() {
		return "jdxTest:"+System.currentTimeMillis();
	}
}
