package com.h3c.cloud.test;

import java.util.Map;

import org.junit.Test;

import com.h3c.cloud.m2_http.util.JSONUtil;
import com.h3c.cloud.utils.HttpClientUtil;
import com.h3c.cloud.utils.Parameters;
import com.h3c.cloud.utils.RedisUtils;
import com.h3c.cloud.utils.StringUtils;

public class UnbindTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void unbind() {
		String url = "https://sohord18.h3c.com/smarthomeback/api/router/unbind";
		String userName = "18667130860";
		String gwSn = "219801A0MV9105Q00030";
		Parameters params = new Parameters();
		params.put("accessToken", getAccessToken(userName));
		params.put("gwSn", gwSn);
		String response = HttpClientUtil.post(url, params);
		if(!StringUtils.isEmpty(response)) {
			Map<String, Object> repMap = JSONUtil.json2Object(response, Map.class);
			if(repMap != null && repMap.containsKey("data")) {
				Map<String, Object> map = JSONUtil.json2Object(repMap.get("data").toString(), Map.class);
				if(repMap.containsKey("retCode") && "0".equals(repMap.get("retCode").toString())) {
					System.out.println("unbind success! \n response="+response + "\n ,map=" + map.toString());
				}
			} else {
				System.out.println(" \n unbind is failed 11111111!!! response="+response);
			}
		} else {
			
			System.out.println("\n unbind is failed 22222!!!");
		}
	}
	
	public static String getAccessToken(String userName) {
		if(StringUtils.isNotEmpty(userName)) {
			return RedisUtils.getValue(userName);
		}
		return null;
	}

}
