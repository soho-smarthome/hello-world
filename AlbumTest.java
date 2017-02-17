package com.h3c.cloud.test;

import java.util.Map;

import org.junit.Test;

import com.h3c.cloud.m2_http.util.JSONUtil;
import com.h3c.cloud.utils.HttpClientUtil;
import com.h3c.cloud.utils.Parameters;
import com.h3c.cloud.utils.StringUtils;

public class AlbumTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void getAlbumById() {
		String url = "https://sohord18.h3c.com/smarthomeback/api/storage/albumDetail";
		String albumId = "37";
		
		Parameters params = new Parameters();
		params.put("albumId", albumId);
//		String response = HttpClientUtil.post(url, params);
		String response = HttpClientUtil.post(url, params);
		if(!StringUtils.isEmpty(response)) {
			Map<String, Object> repMap = JSONUtil.json2Object(response, Map.class);
			Map<String, Object> map = JSONUtil.json2Object(repMap.get("data").toString(), Map.class);
			if("0".equals(repMap.get("retCode").toString())) {
				System.out.println("response="+response+"\n coverUrl="+map.get("coverUrl")+" \n details="+map.get("details"));
			}
			
		} else {
			System.out.println("getAlubmDetail by id="+albumId+" failed !!!!");
		}
		
		
		
	}

}
