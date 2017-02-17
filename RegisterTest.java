package com.h3c.cloud.test;

import java.util.Map;

import org.junit.Test;

import com.h3c.cloud.m2_http.util.JSONUtil;
import com.h3c.cloud.utils.HttpClientUtil;
import com.h3c.cloud.utils.Parameters;
import com.h3c.cloud.utils.RedisUtils;
import com.h3c.cloud.utils.StringUtils;

public class RegisterTest {
	@SuppressWarnings("unchecked")
	@Test
	public void register() {
		String url = "https://sohord18.h3c.com/smarthomeback/api/user/register";
		String mobileNo = "18667130860";
		String password = "e10adc3949ba59abbe56e057f20f883e";
		String checkCode = "999998";
		//设置注册验证码
		RedisUtils.setValue("register_"+mobileNo, checkCode);
		
		Parameters params = new Parameters();
		params.put("mobileNo", mobileNo);
		params.put("password", password);
		params.put("checkCode", checkCode);
		//String response = HttpClientUtil.post(url, JSONUtil.object2JSON(params));
		String response = HttpClientUtil.post(url, params);
		if(!StringUtils.isEmpty(response)) {
			Map<String, Object> repMap = JSONUtil.json2Object(response, Map.class);
			if(repMap != null && repMap.containsKey("data")) {
				Map<String, Object> map = JSONUtil.json2Object(repMap.get("data").toString(), Map.class);
				if(repMap.containsKey("retCode") && "0".equals(repMap.get("retCode").toString())) {
					System.out.println("\n response="+response + "\n ,map=" + map.toString());
				}
			} else {
				System.out.println("\n register is failed 11111111!!! \n response="+response);
			}
		} else {
			
			System.out.println("register is failed 22222!!!");
		}
	}
}
