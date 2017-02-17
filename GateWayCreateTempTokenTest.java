package com.h3c.cloud.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.h3c.cloud.m2_http.util.JSONUtil;
import com.h3c.cloud.utils.HttpClientUtil;
import com.h3c.cloud.utils.Parameters;
import com.h3c.cloud.utils.StringUtils;

public class GateWayCreateTempTokenTest {

	@SuppressWarnings("unchecked")
	@Test
	public void createTempToken() {
		String url = "http://sohord18.h3c.com/smarthomeback/api/gateway/createTempToken";
		String gwSn = "219801A0MV9105Q00030";
		String secretKey = "249945c3Q2lm70uyi71H87rmz4CJ9Ce6";
		/*Parameters params = new Parameters();
		params.put("gwSn", gwSn);
		params.put("secretKey", secretKey);*/
		Map<String, String> params = new HashMap<String, String>();
		params.put("gwSn", gwSn);
		params.put("secretKey", secretKey);
		String response = HttpClientUtil.post(url, JSONUtil.object2JSON(params));
//		String response = HttpClientUtil.post(url, params);
		if(!StringUtils.isEmpty(response)) {
			Map<String, Object> repMap = JSONUtil.json2Object(response, Map.class);
			//Map<String, Object> map = JSONUtil.json2Object(repMap.get("data").toString(), Map.class);
			if("0".equals(repMap.get("retCode").toString())) {
				//System.out.println("response="+response);
			}
			System.out.println("response="+response);
		} else {
			
			System.out.println("GateWay createTempToken failed!!!");
		}
	}
	
}
