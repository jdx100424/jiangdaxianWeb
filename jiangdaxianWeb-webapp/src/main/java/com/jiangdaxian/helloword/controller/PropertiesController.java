package com.jiangdaxian.helloword.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
public class PropertiesController {
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesController.class);

	
	private static final String CACHE_NAME = "hellowordCache";
	
	@RequestMapping("/properties")
	@ResponseBody
	public String index() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zookeeper.url","dddddddddddddddd");
		LOG.info(JSONObject.toJSONString(map));
	
		return JSONObject.toJSONString(map);
	}
}
