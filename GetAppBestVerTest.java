package com.h3c.cloud.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.h3c.cloud.m2_http.util.JSONUtil;
import com.h3c.cloud.utils.HttpClientUtil;
import com.h3c.cloud.utils.HttpClientUtilOld;
import com.h3c.cloud.utils.Parameters;



public class GetAppBestVerTest {

	/**
	 * M2app 获取app版本接口
	 */
	@Test
	public void getAppBestVer() {
		String url = "https://sohord18.h3c.com/smarthomeback/api/getAppBestVer";
		String userSystemId = "100007";
		String devType = "2";
		String appType = "0";
		Parameters params = new Parameters();
		params.put("userSystemId", userSystemId);
		params.put("devType", devType);
		params.put("appType", appType);
		String response = HttpClientUtil.post(url, params);
		System.out.println("response="+response);
	}
	
	/**
	 * 魔术家App 获取app版本接口
	 */
	@Test
	public void getAppBestVerNew() {
		String url = "http://sohord18.h3c.com/smarthomeback/rest/ihomers/getAppBestVerNew";
		String userName = "18667130860";
		String devType = "2";
		String appType = null;
		Map<String, String> params = new HashMap<String, String>();
//		Parameters params = new Parameters();
		params.put("userName", userName);
		params.put("devType", devType);
		params.put("appType", appType);
		String response = HttpClientUtilOld.httpPostJson(url, JSONUtil.object2JSON(params));
//		String response = HttpClientUtil.post(url, params);
		System.out.println("response="+response);
	}
}
