package com.jiangdaxian.helloword.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;

import com.jiangdaxian.helloword.service.HellowordService;

@Controller
public class HellowordController {
	private static final Logger LOG = LoggerFactory.getLogger(HellowordController.class);
	@Autowired
	private HellowordService hellowordService;

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		String str = hellowordService.get();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("time", System.currentTimeMillis());
		map.put("helloword", str);
		LOG.info(JSONObject.toJSONString(map));
		return JSONObject.toJSONString(map);
	}
	
	@RequestMapping("/kafka")
	@ResponseBody
	public String kafka() {
		hellowordService.sendKafka();
		Map<String, Object> map = new HashMap<String, Object>();
		return JSONObject.toJSONString(map);
	}
	
	@RequestMapping("/throwError")
	@ResponseBody
	public String throwError() {
		String str = null;
		if(str.equals("3")) {
			
		}
		return JSONObject.toJSONString(str);
	}
}