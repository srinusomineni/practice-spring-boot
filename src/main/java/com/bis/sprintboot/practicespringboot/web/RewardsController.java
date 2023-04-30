package com.bis.sprintboot.practicespringboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bis.sprintboot.practicespringboot.dto.UserPurchases;
import com.bis.sprintboot.practicespringboot.service.RewardUsersService;
import com.bis.sprintboot.practicespringboot.service.UserPurchasesService;

@RestController
@RequestMapping("/rewards")
public class RewardsController {
	
	@Autowired
	private UserPurchasesService userPurchasesService;
	
	@Autowired
	private RewardUsersService rewardUsersService;
	
	@RequestMapping("/retriveAllPurchasesWithRewardPoints")
	public List<UserPurchases> retriveAllPurchasesWithRewardPoints(){
		return userPurchasesService.getUserPurchasesWithRewardPoints();
	}
	
	@RequestMapping("/retrivePurchasesByuserId/{id}")
	public List<UserPurchases> retrivePurchases(@PathVariable("id") Long id) {
		return rewardUsersService.getRewardPintsByUserId(id);
	}
}
