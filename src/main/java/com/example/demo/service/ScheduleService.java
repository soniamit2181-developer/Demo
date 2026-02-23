package com.example.demo.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
	
	// method to schedule tasks
	//@Scheduled(fixedRate = 2000)
	@Scheduled(fixedDelay = 3000)
	public void scheduleFixedRate() {
		Date date = new Date();
		System.out.println("Current Date===>" + date);
	}

}
