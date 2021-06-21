package com.jt.payment.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.payment.entity.Payment;
import com.jt.payment.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(processPaymentStatus());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}
	
	private String processPaymentStatus() {
		// should be 3rd party payment gateway (paypapal, paytem.....)
		return new Random().nextBoolean() ? "success" : "failure";
	}
}
