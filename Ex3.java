package com.exam;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader reader=null;
		
		try {
			URL url = new URL("https://www.daum.net/");
			
			
			//URL 객체로부터 urlConnection 객체 생성
			HttpURLConnection con =(HttpURLConnection)url.openConnection();
			
			reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			
			String line="";
			while((line=reader.readLine()) !=null) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	}

}
