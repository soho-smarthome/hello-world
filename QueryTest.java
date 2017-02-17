package com.h3c.cloud.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.h3c.cloud.m2_http.util.JSONUtil;
import com.h3c.cloud.utils.HttpClientUtil;
import com.h3c.cloud.utils.Parameters;
import com.h3c.cloud.utils.RedisUtils;
import com.h3c.cloud.utils.StringUtils;

public class QueryTest {
	@SuppressWarnings("unchecked")
	@Test
	public void query() {
		String url = "http://sohord18.h3c.com/smarthomeback/api/user/query";
		String userName = "18667130860";
		Parameters params = new Parameters();
		params.put("accessToken", getAccessToken(userName));
		String response = HttpClientUtil.post(url, params);
		if(!StringUtils.isEmpty(response)) {
			Map<String, Object> repMap = JSONUtil.json2Object(response, Map.class);
			if(repMap != null && repMap.containsKey("data")) {
				Map<String, Object> map = JSONUtil.json2Object(repMap.get("data").toString(), Map.class);
				if(repMap.containsKey("retCode") && "0".equals(repMap.get("retCode").toString())) {
					System.out.println("query success! \n response="+response + "\n ,map=" + map.toString());
				}
			} else {
				System.out.println("query is failed 11111111!!! response="+response);
			}
		} else {
			
			System.out.println("query is failed 22222!!!");
		}
		
	}

	public static String getAccessToken(String userName) {
		if(StringUtils.isNotEmpty(userName)) {
			return RedisUtils.getValue(userName);
		}
		return null;
	}
}
