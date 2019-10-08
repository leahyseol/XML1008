package com.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//URL  객체로부터 바이트 입력 스트림을 가져오기
		
		BufferedReader reader = null;
		
		try {
			URL url = new URL("https://www.naver.com");
			//openStream(); URL주소와 연결하여 입력 받을 수 있게하는 INPUTSTREAM 객체리턴
			InputStream is = url.openStream();
			
			reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String line = "";
			
			while((line=reader.readLine()) !=null) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		}
		
	}//main method


