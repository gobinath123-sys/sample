package com.onesoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Annotations {
	@Autowired
	@Qualifier("super")
	private Cars cars;
	
	@GetMapping(value="/getthis")
	public String getThis() {
		return cars.givemsg();
	}
	
	@Value("${check.this}")
	private String a;
	
	@GetMapping(value="/getname")
	public String display() {
		return a+" pk gobi";
	}

}
