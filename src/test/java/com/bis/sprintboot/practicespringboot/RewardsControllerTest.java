package com.bis.sprintboot.practicespringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Base64;
import java.util.Scanner;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RewardsControllerTest {


	private static String SPECIFIC_QUESTION_URL = "/rewards/retrivePurchasesByuserId/";
	
	
	
	
	@Autowired
	private TestRestTemplate template;
		
	@Test
	void retrieveRewardPoints_NoDataScenario() throws JSONException {

		HttpHeaders headers = createHttpContentTypeAndAuthorizationHeaders();
		
		HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> responseEntity 
			= template.exchange(SPECIFIC_QUESTION_URL+"2", HttpMethod.GET, httpEntity, String.class);
		
		//ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);

		String expectedResponse = "[]";

		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
		 
	}
	
	@Test
	void retrieveRewardPoints_withDataScenario() throws JSONException {
		
		HttpHeaders headers = createHttpContentTypeAndAuthorizationHeaders();
		
		HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> responseEntity 
			= template.exchange(SPECIFIC_QUESTION_URL+"1", HttpMethod.GET, httpEntity, String.class);

		StringBuffer buff = new StringBuffer("");
		//ResponseEntity<String> responseEntity = template.getForEntity(GENERIC_QUESTIONS_URL, String.class);
		try {
			File file =new File(getClass().getClassLoader().getResource("result.json").getFile());
			Scanner scanner = new Scanner(file);
			System.out.println("Read text file using Scanner");
			
			//read line by line
			while(scanner.hasNextLine()){
			    //process each line
				buff.append(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		
		JSONAssert.assertEquals(buff.toString(), responseEntity.getBody(), false);
		 
	}

	private HttpHeaders createHttpContentTypeAndAuthorizationHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Authorization", "Basic " + performBasicAuthEncoding("admin","password"));
		return headers;
	}
	
	
	String performBasicAuthEncoding(String user, String password) {
		String combined = user + ":" + password;
		byte[] encodedBytes = Base64.getEncoder().encode(combined.getBytes());
		return new String(encodedBytes);
	}
}
