package com.h3c.cloud.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.h3c.cloud.m2_http.util.JSONUtil;
import com.h3c.cloud.utils.HttpClientUtil;
import com.h3c.cloud.utils.Parameters;
import com.h3c.cloud.utils.RedisUtils;
import com.h3c.cloud.utils.StringUtils;

public class UpdateGwNameTest {
	
	@SuppressWarnings({ "unchecked", "unused" })
	@Test
	public void updateGwName() {
		String url = "https://sohord18.h3c.com/api/router/updateGwName";
		String gwSn = "219801A0MV9105Q00030";
		String gwName = "M2_B0_zk_30";
		String userName = "18667130860";
		Parameters params = new Parameters();
		params.put("gwSn", gwSn);
		params.put("gwName", gwName);
		params.put("accessToken", getAccessToken(userName));
		String response = HttpClientUtil.post(url, params);
		if(!StringUtils.isEmpty(response)) {
			Map<String, Object> repMap = JSONUtil.json2Object(response, Map.class);
			if(repMap != null && repMap.containsKey("data")) {
				Map<String, Object> map = JSONUtil.json2Object(repMap.get("data").toString(), Map.class);
				if("0".equals(repMap.get("retCode").toString())) {
					System.out.println("response="+response);
				}
			} else {
				System.out.println("\n UpdateGwName is subSuc 11111111!!! response="+response);
			}
		} else {
			
			System.out.println("\n UpdateGwName is failed 22222!!!");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void updateGwNameBySelf() {
		String url = "https://sohord18.h3c.com/api/zk/updateGwName";
		String userName = "18667130860";
		Parameters params = new Parameters();
		params.put("accessToken", getAccessToken(userName));
		String response = HttpClientUtil.post(url, params);
		if(!StringUtils.isEmpty(response)) {
			Map<String, Object> repMap = JSONUtil.json2Object(response, Map.class);
			if(repMap != null && repMap.containsKey("data")) {
				//Map<String, Object> map = JSONUtil.json2Object(repMap.get("data").toString(), Map.class);
				if("0".equals(repMap.get("retCode").toString())) {
					System.out.println("response="+response);
				}
			} else {
				System.out.println("\n UpdateGwName is subSuc 11111111!!! response="+response);
			}
		} else {
			
			System.out.println("\n UpdateGwName is failed 22222!!!");
		}
	}
	
	public static String getAccessToken(String userName) {
		if(StringUtils.isNotEmpty(userName)) {
			return RedisUtils.getValue(userName);
		}
		return null;
	}

}
