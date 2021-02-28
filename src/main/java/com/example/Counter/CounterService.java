package com.example.Counter;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.CounterNumber;

@Service
public class CounterService {
	
	@Autowired
	NumberRepository numberRepository;
	
	@Transactional
	public void incrementCount() throws InterruptedException {
		
		
		CounterNumber counterObj = numberRepository.findNumberForWrite(1l).get();
		counterObj.setCount(counterObj.getCount()+1);
		numberRepository.save(counterObj);
		
	}
	
}
