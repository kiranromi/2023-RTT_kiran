package com.kiran.myServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class TennisCoach implements Coach  {
private FortuneServices fortuneService;
	
	// this is default constructor
	public TennisCoach() {
	
	}
	@Autowired
	public TennisCoach(FortuneServices theFortuneService) {
		fortuneService = theFortuneService;
	}




	@Override
	public String getDailyWorkout() {
		
		return "Practice two hours Tennis daily ";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();

	}

}
