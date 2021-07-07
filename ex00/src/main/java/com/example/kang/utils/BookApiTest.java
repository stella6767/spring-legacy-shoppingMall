package com.example.kang.utils;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.kang.domain.Book;
import com.example.kang.domain.Document;
import com.example.kang.web.HomeController;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BookApiTest {

	private static final Logger log = LoggerFactory.getLogger(BookApiTest.class);

	
	private static final String kakaoBookUrl = "https://dapi.kakao.com/v3/search/book";
	
	private static final String clientKey = "1b7846d3dd8606fdce13951f9a8ab5d7";
	
	
	
	public static Book getApi() {

		
		log.info("???");
		
		try {
			HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
			factory.setConnectTimeout(5000); // 타임아웃 설정 5초
			factory.setReadTimeout(5000);// 타임아웃 설정 5초
			HttpClient httpClient = HttpClientBuilder.create() 
					.setMaxConnTotal(100) // connection pool 적용 
					.setMaxConnPerRoute(5) // connection pool 적용 
					.build();
			factory.setHttpClient(httpClient);
			RestTemplate restTemplate = new RestTemplate(factory);
			
			
//		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
//		interceptors.add(new HeaderRequestInterceptor("HTTP_AUTH_ACCESS_ID", "skyer9"));
			
			
			String query = "난";
			
			UriComponents builder = UriComponentsBuilder.fromHttpUrl(kakaoBookUrl)
			        .queryParam("size", 50)
			        .queryParam("page", 1)
			       // .queryParam("query", URLEncoder.encode(query,"UTF-8" ))
			        .queryParam("query", query)
			        .build();
			
			log.info(builder.toUriString());
			
//			builder.build(false).encode("UTF-8");
//			
			HttpHeaders headers = new HttpHeaders(); 
			headers.set("Authorization", "KakaoAK 1b7846d3dd8606fdce13951f9a8ab5d7");  
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<?> request = new HttpEntity(headers);

			
			   ResponseEntity<String> responseEntity = restTemplate
					   .exchange(builder.toUriString(), 
							   HttpMethod.GET, 
							   request,  
							   String.class);
			
			   
			   log.info("responseEntity: {}", responseEntity);
			   
//			   HashMap<String, Object> result = new HashMap<String, Object>();
//			   esult.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
//	            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
//	            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인
	 
	            log.info(responseEntity.getBody());
	            log.info(responseEntity.getHeaders().toString());
	            //log.info(responseEntity.getStatusCodeValue().toString);
			   
			   
	            ObjectMapper mapper = new ObjectMapper();
	            
	            Book book = mapper.readValue(responseEntity.getBody(),Book.class);
	            
	         
	            return book;
			   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return null;
	}

}