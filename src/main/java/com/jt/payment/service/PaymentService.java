package com.jt.payment.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.payment.dto.PaymentDto;
import com.jt.payment.entity.Payment;
import com.jt.payment.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public PaymentDto doPayment(PaymentDto paymentDto) {
		Payment payment = new Payment(paymentDto.getId(), paymentDto.getPaymentStatus(), paymentDto.getTransactionId(),
				paymentDto.getOrderId(), paymentDto.getAmount());
		payment.setPaymentStatus(processPaymentStatus());
		payment.setTransactionId(UUID.randomUUID().toString());
		Payment savedPayment = paymentRepository.save(payment);

		return new PaymentDto(savedPayment.getId(), savedPayment.getPaymentStatus(), savedPayment.getTransactionId(),
				savedPayment.getOrderId(), savedPayment.getAmount());
	}

	private String processPaymentStatus() {
		// should be 3rd party payment gateway (paypapal, paytem.....)
		return new Random().nextBoolean() ? "success" : "failure";
	}
}
