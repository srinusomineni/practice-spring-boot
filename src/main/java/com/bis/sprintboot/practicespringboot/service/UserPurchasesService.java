package com.bis.sprintboot.practicespringboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bis.sprintboot.practicespringboot.dto.UserPurchases;
import com.bis.sprintboot.practicespringboot.repo.UserPurchasesRepository;

@Service
@Transactional
public class UserPurchasesService {
	
	private static final double MIN_CAP_AMOUNT = 50.00;
	private static final double SECOND_CAP_ELIGLIBLE_AMOUNT = 100.00;
	private static final int FIRST_TIER_CONFIG = 1;
	private static final int SECOND_TIER_CONFIG = 2;
	
	@Autowired
	private UserPurchasesRepository userPurchasesRepository;
	
	public List<UserPurchases> getUserPurchasesWithRewardPoints() {
		List<UserPurchases> userPurchases = userPurchasesRepository.findAll();
		
		System.out.println(userPurchases.size());
		
		if(!userPurchases.isEmpty()) {
			userPurchases.stream().forEach(purchase -> {
			//	System.out.println(purchase.toString());
				purchase.setRewardPoints(calculateRewardPoints(purchase.getTransactionAmount()));
				System.out.println(purchase.toString());
			});
		}
		
		return userPurchases;
	}
	
	public List<UserPurchases> getUserPurchasesbyUserId(Long userId) {
		List<UserPurchases> userPurchases = userPurchasesRepository.findByUserId(userId);
		
		System.out.println(userPurchases.size());
		
		if(!userPurchases.isEmpty()) {
			userPurchases.stream().forEach(purchase -> {
			//	System.out.println(purchase.toString());
				purchase.setRewardPoints(calculateRewardPoints(purchase.getTransactionAmount()));
				System.out.println(purchase.toString());
			});
		}
		
		return userPurchases;
	}
	
	
	public static int calculateRewardPoints(String amount) {
		double transAmount = Double.parseDouble(amount);
		if(transAmount<MIN_CAP_AMOUNT) {
			return 0;
		} else if(transAmount>=MIN_CAP_AMOUNT && transAmount<=SECOND_CAP_ELIGLIBLE_AMOUNT) {
			return (int)(transAmount-MIN_CAP_AMOUNT)*FIRST_TIER_CONFIG;
		} else {
			double points = (SECOND_CAP_ELIGLIBLE_AMOUNT - MIN_CAP_AMOUNT)*FIRST_TIER_CONFIG;
			points = points + ((transAmount - SECOND_CAP_ELIGLIBLE_AMOUNT)*SECOND_TIER_CONFIG);
			return (int)points;
		}
	}
}
