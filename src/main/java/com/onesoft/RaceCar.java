package com.onesoft;

//import org.springframework.context.annotation.Primary; 
import org.springframework.stereotype.Service;

//@Primary
@Service(value="race")
public class RaceCar implements Cars{
	 
	public String givemsg() {
		return "This is Race Car";
	}

}
