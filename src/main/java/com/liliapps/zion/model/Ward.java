package com.liliapps.zion.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ward {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long quantity;

	@Column(nullable = false)
	private LocalDateTime lastProcess;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getLastProcess() {
		return lastProcess;
	}

	public void setLastProcess(LocalDateTime lastProcess) {
		this.lastProcess = lastProcess;
	}

	public Ward(Long quantity, LocalDateTime lastProcess) {
		this.quantity = quantity;
		this.lastProcess = lastProcess;
	}

	/**
	 * LastProcess = Gera moedas por hora baseado na quantidade de ala.
	 * 
	 * Ex. 10 alas == 100 moedas
	 * 
	 */

}
