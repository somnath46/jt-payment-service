package com.jt.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.payment.dto.PaymentDto;
import com.jt.payment.service.PaymentService;


@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping
	public ResponseEntity<PaymentDto> doPayment(@RequestBody PaymentDto paymentDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.doPayment(paymentDto));
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<List<PaymentDto>> findPaymentByOrderId(@PathVariable Integer orderId) {
		return ResponseEntity.ok(paymentService.findPaymentByOrderId(orderId));
	}
}
