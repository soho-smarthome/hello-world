package com.h3c.cloud.test;

import java.util.Map;

import org.junit.Test;

import com.h3c.cloud.m2_http.util.JSONUtil;
import com.h3c.cloud.utils.HttpClientUtil;
import com.h3c.cloud.utils.Parameters;
import com.h3c.cloud.utils.StringUtils;

public class GetGwPicTest {
	@SuppressWarnings("unchecked")
	@Test
	public void getGwPicture() {
		String url = "https://sohord18.h3c.com/smarthomeback/api/getGwPicture";
		String gwSn = "219801A12X9105Q00086";
		Parameters params = new Parameters();
		params.put("gwSn", gwSn);
		String response = HttpClientUtil.post(url, params);
		if(!StringUtils.isEmpty(response)) {
			Map<String, Object> repMap = JSONUtil.json2Object(response, Map.class);
			if(repMap != null && repMap.containsKey("data")) {
				if("0".equals(repMap.get("retCode").toString())) {
					System.out.println("response="+response);
				}
			} else {
				System.out.println("\n getGwPicture is subSuc 11111111!!! response="+response);
			}
		} else {
			
			System.out.println("\n getGwPicture is failed 22222!!!");
		}
	}

}
