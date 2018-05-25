package com.jiangdaxian.helloword.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jiangdaxian.common.util.properties.PropertiesUtils;

@Controller
public class PropertiesController {
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesController.class);
	
	@Autowired
	private EhCacheCacheManager ehCacheCacheManager;
	
	private static final String CACHE_NAME = "hellowordCache";
	
	@RequestMapping("/properties")
	@ResponseBody
	public String index() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zookeeper.url",PropertiesUtils.getProperty("zookeeper.url"));
		LOG.info(JSONObject.toJSONString(map));
		
		Object obj = ehCacheCacheManager.getCache(CACHE_NAME).get("jdx");
		if(obj==null) {
			LOG.warn(CACHE_NAME + ",not data");
			ehCacheCacheManager.getCache(CACHE_NAME).put("jdx", "1111");
		}else {
			LOG.warn(CACHE_NAME + ",data");
		}
		return JSONObject.toJSONString(map);
	}
}
