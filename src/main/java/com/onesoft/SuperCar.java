package com.onesoft;

import org.springframework.stereotype.Service;

@Service(value="super")
public class SuperCar implements Cars {
	
	public String givemsg() {
		return "This is super car";
	}

}
