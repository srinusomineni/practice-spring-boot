package com.bis.sprintboot.practicespringboot.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="tbl_users")
@Entity
public class RewardUsers implements Serializable {

	private static final long serialVersionUID = -4679695002911118198L;
	
	@Id
    @GeneratedValue
	private Long id;
	private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RewardUsers rewardUsers = (RewardUsers) o;
        return id == rewardUsers.id && username.equals(rewardUsers.username);
    }

	@Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    @Override
    public String toString() {
        return "RewardUsers{" +
          "id=" + id +
          ", name='" + username + '\'' +
          '}';
    }

}
