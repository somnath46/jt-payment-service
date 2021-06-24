package com.jt.payment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	List<Payment> findByOrderId(Integer orderId);

}
