package com.liliapps.zion.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long quantityActive;

	@Column(nullable = false)
	private Long quantityInactive;

	@Column(nullable = false)
	private LocalDateTime lastTimeAlter;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantityActive() {
		return quantityActive;
	}

	public void setQuantityActive(Long quantityActive) {
		this.quantityActive = quantityActive;
	}

	public Long getQuantityInactive() {
		return quantityInactive;
	}

	public void setQuantityInactive(Long quantityInactive) {
		this.quantityInactive = quantityInactive;
	}

	public LocalDateTime getLastTimeAlter() {
		return lastTimeAlter;
	}

	public void setLastTimeAlter(LocalDateTime lastTimeAlter) {
		this.lastTimeAlter = lastTimeAlter;
	}

	public Person(Long quantityActive, Long quantityInactive, LocalDateTime lastTimeAlter) {
		this.quantityActive = quantityActive;
		this.quantityInactive = quantityInactive;
		this.lastTimeAlter = lastTimeAlter;
	}

}
