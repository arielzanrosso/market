package com.market.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false, length = 50)
	private String mode;
	
	@Transient
	private BigDecimal amount;
	
	@Column(nullable = false)
	private BigDecimal installments;
	
	@Transient
	private BigDecimal firstInstallmentValue;
	
	@Transient
	private BigDecimal othersInstallmentValue;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getInstallments() {
		return installments;
	}

	public void setInstallments(BigDecimal installments) {
		this.installments = installments;
	}

	public BigDecimal getFirstInstallmentValue() {
		return firstInstallmentValue;
	}

	public void setFirstInstallmentValue(BigDecimal firstInstallmentValue) {
		this.firstInstallmentValue = firstInstallmentValue;
	}

	public BigDecimal getOthersInstallmentValue() {
		return othersInstallmentValue;
	}

	public void setOthersInstallmentValue(BigDecimal othersInstallmentValue) {
		this.othersInstallmentValue = othersInstallmentValue;
	}

	
	
	

	

	
	
	
	
	
	

}
