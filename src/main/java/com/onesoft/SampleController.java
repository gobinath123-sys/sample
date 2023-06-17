package com.onesoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SampleController {
	@Autowired
	RestTemplate rt;
	@GetMapping(value="/getstring1")
	public String show() {
		String url="http://localhost:8081/getstring";
		ResponseEntity<String> t=rt.exchange(url,HttpMethod.GET,null,String.class);
		String result=t.getBody();
	
	
	return result;
	}

}
