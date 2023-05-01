package com.bis.sprintboot.practicespringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bis.sprintboot.practicespringboot.dto.RewardUsers;
import com.bis.sprintboot.practicespringboot.dto.UserPurchases;
import com.bis.sprintboot.practicespringboot.repo.RewardUserRepository;

@Service
@Transactional
public class RewardUsersService {
	
	@Autowired
	private RewardUserRepository rewardUserRepository;
	
//	public List<UserPurchases> getRewardPintsByUserId(Long id) {
//		
//		Optional<RewardUsers> userPurchases = rewardUserRepository.findById(id);
//		List<UserPurchases> listPurchases = new ArrayList<UserPurchases>();
//		if(userPurchases.isPresent()) {
//			listPurchases = userPurchases.get().getListUserPurchases();
//			if(!listPurchases.isEmpty()) {
//				listPurchases.stream().forEach(purchase -> {
//					System.out.println(purchase.toString());
//					purchase.setRewardPoints(UserPurchasesService.calculateRewardPoints(purchase.getTransactionAmount()));
//					System.out.println(purchase.toString());
//				});
//			}
//		}
//		
//		return listPurchases;
//	}

}
