package com.bis.sprintboot.practicespringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bis.sprintboot.practicespringboot.dto.UserPurchases;

@Repository
public interface UserPurchasesRepository extends JpaRepository<UserPurchases, Long> {
}
