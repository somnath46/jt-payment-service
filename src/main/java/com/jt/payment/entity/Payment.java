package com.jt.payment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue
	private Integer id;
	private String paymentStatus;
	private String transactionId;
	private Integer orderId;
	private double amount;
}
