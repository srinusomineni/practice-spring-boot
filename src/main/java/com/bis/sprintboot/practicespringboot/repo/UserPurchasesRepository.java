package com.bis.sprintboot.practicespringboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bis.sprintboot.practicespringboot.dto.UserPurchases;

@Repository
public interface UserPurchasesRepository extends JpaRepository<UserPurchases, Long> {
	@Query(
			  value = "SELECT * FROM \"tbl_user_purchases\" u WHERE u.\"user_id\" = ?1", 
			  nativeQuery = true)
	List<UserPurchases> findByUserId(Long userId);
}
