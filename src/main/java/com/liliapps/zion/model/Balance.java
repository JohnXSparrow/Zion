package com.liliapps.zion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Balance {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long moneyQuantity;

	@Column(nullable = false)
	private Long gemQuantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMoneyQuantity() {
		return moneyQuantity;
	}

	public void setMoneyQuantity(Long moneyQuantity) {
		this.moneyQuantity = moneyQuantity;
	}

	public Long getGemQuantity() {
		return gemQuantity;
	}

	public void setGemQuantity(Long gemQuantity) {
		this.gemQuantity = gemQuantity;
	}

	public Balance(Long moneyQuantity, Long gemQuantity) {
		this.moneyQuantity = moneyQuantity;
		this.gemQuantity = gemQuantity;
	}

	public Balance() {
		super();
	}
	
}
