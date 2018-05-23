package com.jiangdaxian.helloword.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jiangdaxian.common.util.properties.PropertiesUtils;

@Controller
public class PropertiesController {
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesController.class);
	
	@RequestMapping("/properties")
	@ResponseBody
	public String index() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zookeeper.url",PropertiesUtils.getProperty("zookeeper.url"));
		LOG.info(JSONObject.toJSONString(map));
		return JSONObject.toJSONString(map);
	}
}
