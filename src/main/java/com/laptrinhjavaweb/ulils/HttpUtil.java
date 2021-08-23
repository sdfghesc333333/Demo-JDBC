package com.laptrinhjavaweb.ulils;

import java.io.BufferedReader;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	
	private String value;
	
	public HttpUtil (String value) {
		this.value = value;
	}
	
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static HttpUtil of (BufferedReader reader) {
		StringBuffer sb = new StringBuffer();
		try {
			String line;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new HttpUtil(sb.toString());
	}
}
