package com.h3c.cloud.test;

import java.util.Map;

import org.junit.Test;

import com.h3c.cloud.m2_http.util.JSONUtil;
import com.h3c.cloud.utils.HttpClientUtil;
import com.h3c.cloud.utils.Parameters;
import com.h3c.cloud.utils.StringUtils;

public class SetPushSwithchTest {

	@SuppressWarnings("unchecked")
	@Test
	public void setPushSwitch() {
		String url = "https://sohord18.h3c.com/smarthomeback/api/user/setPushSwitch";
		String state = "on";
		String deviceToken = "4489cc623ba9f0520a414224c191e94eaec1bd338e1101cf75881216f1ab1ced";
		Parameters params = new Parameters();
		params.put("state", state);
		params.put("deviceToken", deviceToken);
		String response = HttpClientUtil.post(url, params);
		if(!StringUtils.isEmpty(response)) {
			Map<String, Object> repMap = JSONUtil.json2Object(response, Map.class);
			if(repMap != null && repMap.containsKey("data")) {
				if("0".equals(repMap.get("retCode").toString())) {
					System.out.println("response="+response);
				}
			} else {
				System.out.println("\n setPushSwitch is subSuc 11111111!!! response="+response);
			}
		} else {
			
			System.out.println("\n setPushSwitch is failed 22222!!!");
		}
		
	}
}
