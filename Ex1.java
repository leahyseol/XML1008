package com.exam;

import java.net.MalformedURLException;
import java.net.URL;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//file class : 파일정보 가져올때 주로 사용
		// URL class : 인터넷상의 주소에 해당하는 자원 정보 가져올때 사용
		
		URL naverNews= null;
		URL itNews = null;
		
		try {
			//절대경로로 url  객체 생성
			naverNews=new URL("https://news.naver.com:80");
			//상대경로로 url 객체 생성
			itNews=new URL(naverNews, "main/list.nhn?mode=LPOD&mid=sec&oid=028&listType=paper&date=20191008");
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("protocol: " + itNews.getProtocol());
		System.out.println("host: " + itNews.getHost()); //host name
		System.out.println("port: " + itNews.getPort()); //port number
		System.out.println("path: " + itNews.getPath());
		System.out.println("filename: " +itNews.getFile());
		
	}//main

}
