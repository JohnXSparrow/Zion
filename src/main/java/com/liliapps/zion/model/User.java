package com.liliapps.zion.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(unique = true)
	private String email;

	@Column(nullable = false)
	private LocalDateTime dateRegister;

	@Column(nullable = false)
	@Type(type = "true_false")
	private boolean isAccountSaved;

	@Column
	private int tokenUid;

	@Column
	private String facebookId;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Balance balance;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Temple temple;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Stake stake;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Ward ward;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Person person;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Missionary missionary;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(LocalDateTime dateRegister) {
		this.dateRegister = dateRegister;
	}

	public boolean isAccountSaved() {
		return isAccountSaved;
	}

	public void setAccountSaved(boolean isAccountSaved) {
		this.isAccountSaved = isAccountSaved;
	}

	public int getTokenUid() {
		return tokenUid;
	}

	public void setTokenUid(int tokenUid) {
		this.tokenUid = tokenUid;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	@JsonIgnore
	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	@JsonIgnore
	public Temple getTemple() {
		return temple;
	}

	public void setTemple(Temple temple) {
		this.temple = temple;
	}

	@JsonIgnore
	public Stake getStake() {
		return stake;
	}

	public void setStake(Stake stake) {
		this.stake = stake;
	}

	@JsonIgnore
	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	@JsonIgnore
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@JsonIgnore
	public Missionary getMissionary() {
		return missionary;
	}

	public void setMissionary(Missionary missionary) {
		this.missionary = missionary;
	}
	
	public User() {
		this.balance = new Balance(1000L, 100L);
		this.temple = new Temple(0L, 1);
		this.stake = new Stake(0L);
		this.ward = new Ward(1L, LocalDateTime.now());
		this.person = new Person(100L, 0L, LocalDateTime.now());
		this.missionary = new Missionary(2L);
		this.isAccountSaved = false;
		this.dateRegister = LocalDateTime.now();
	}

}
