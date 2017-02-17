package com.h3c.cloud.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class CUrlTest {
	
	@Test
	public void curl() {
		String url = "https://sohord19.h3c.com/smarthomeback/api/gateway/createTempToken";
		
		 String[] cmds = {"curl", "-i", "-w", "状态%{http_code}；DNS时间%{time_namelookup}；"  
	                + "等待时间%{time_pretransfer}TCP 连接%{time_connect}；发出请求%{time_starttransfer}；"  
	                + "总时间%{time_total}","https://sohord19.h3c.com"};  
		 ProcessBuilder pb=new ProcessBuilder(cmds);  
	        pb.redirectErrorStream(true);  
	        Process p;  
	        try {  
	            p = pb.start();  
	            BufferedReader br=null;  
	            String line=null;  
	              
	            br=new BufferedReader(new InputStreamReader(p.getInputStream()));  
	            while((line=br.readLine())!=null){  
	                    System.out.println("\t"+line);  
	            }  
	            br.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
		
	}

}
