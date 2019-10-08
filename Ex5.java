package com.exam;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ex5 {

	public static void main(String[] args) {
		// XML 파서 종류 2가지 : DOM파서, SAX파서
		List<PersonVO> personList = new ArrayList<PersonVO>();
		
		try {
			
			URL url = Ex5.class.getResource("personList.xml");
			InputStream is = url.openStream();
			
			// DOM parser로 파싱하기.
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document=builder.parse(is); //파싱 수행 후 결과로 document 객체 리턴
			
			System.out.println("파싱 후 document 객체 생성완료");
			
			//레코드 단위인 person 태그이름 기준으로 노드리스트로 가져오기
			NodeList nodeList=document.getElementsByTagName("person");
			
			
			for(int i=0; i<nodeList.getLength(); i++) {
				PersonVO personVO= new PersonVO();
				Node node = nodeList.item(i);
				
				NamedNodeMap nodeMap = node.getAttributes();
				for(int j=0; j<nodeMap.getLength(); j++) {
					Node attrNode = nodeMap.item(j);
					if(attrNode.getNodeName().equals("id")) {
						String id = attrNode.getNodeValue();
						personVO.setId(Integer.parseInt(id));
						
					}
				}//inner for
				
				//person node의 자식요소들을 가져오기
				NodeList childNodeList = node.getChildNodes();
				
				//자식요소의 텍스트값을 찾기
				for(int j=0; j<childNodeList.getLength(); j++) {
					Node childNode= childNodeList.item(j);
					
					if(childNode.getNodeName().equals("name")) {
						//String name=childNode.getChildNodes().item(0).getNodeValue();
						String name= childNode.getFirstChild().getNodeValue();
						personVO.setName(name);
					} else if(childNode.getNodeName().equals("company")) {
						String company = childNode.getFirstChild().getNodeValue();
						personVO.setCompany(company);
					}
					
				}//Inner for
				 
				//VO setting이 끝나면 리스트에 추가
				personList.add(personVO);
				
				
				
			}//outer for
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("personList 생성 완료");
	
		for(PersonVO personVO :personList) {
			System.out.println(personVO.toString());//출력
		}
	}//main

}
