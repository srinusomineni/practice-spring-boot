package com.bis.sprintboot.practicespringboot.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name="tbl_user_purchases")
@Entity
public class UserPurchases implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
	private long id;
	private String transactionAmount;
	private Date transactionDate;
	private int rewardPoints;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
	private RewardUsers rewardUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public RewardUsers getRewardUser() {
		return rewardUser;
	}

	public void setRewardUser(RewardUsers rewardUser) {
		this.rewardUser = rewardUser;
	}
	
	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserPurchases userPurchases = (UserPurchases) o;
        return id == userPurchases.id && transactionAmount.equals(userPurchases.transactionAmount) && transactionDate == userPurchases.transactionDate && rewardUser == userPurchases.rewardUser && rewardPoints == userPurchases.rewardPoints;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionAmount, transactionDate, rewardUser, rewardPoints);
    }

    @Override
    public String toString() {
        return "UserPurchases{" +
          "id=" + id +
          ", transactionAmount='" + transactionAmount + '\'' +
          ", transactionDate='" + transactionDate +'\''+
          ", rewardPoints='" + rewardPoints +'\'';
    }

	
	
}
