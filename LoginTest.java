package com.h3c.cloud.test;

import java.util.Map;

import org.junit.Test;

import com.h3c.cloud.m2_http.util.JSONUtil;
import com.h3c.cloud.utils.HttpClientUtil;
import com.h3c.cloud.utils.Parameters;
import com.h3c.cloud.utils.StringUtils;

public class LoginTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void login() {
		String url = "https://sohord18.h3c.com/smarthomeback/api/user/login";
		String mobileNo = "18667130860";
		String password = "e10adc3949ba59abbe56e057f20f883e";
		Parameters params = new Parameters();
		params.put("mobileNo", mobileNo);
		params.put("password", password);
		//String response = HttpClientUtil.post(url, JSONUtil.object2JSON(params));
		String response = HttpClientUtil.post(url, params);
		if(!StringUtils.isEmpty(response)) {
			Map<String, Object> repMap = JSONUtil.json2Object(response, Map.class);
			if(repMap != null && repMap.containsKey("data")) {
				Map<String, Object> map = JSONUtil.json2Object(repMap.get("data").toString(), Map.class);
				if(repMap.containsKey("retCode") && "0".equals(repMap.get("retCode").toString())) {
					System.out.println("response="+response + "\n ,map=" + map.toString());
				}
			} else {
				System.out.println("login is failed 11111111!!!");
			}
		} else {
			
			System.out.println("login is failed 22222!!!");
		}
	}

}
