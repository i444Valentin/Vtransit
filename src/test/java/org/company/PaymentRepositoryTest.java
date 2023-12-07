package org.company;

import org.company.dao.entity.Payment;
import org.company.dao.entity.Route;
import org.company.repository.PaymentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PaymentRepositoryTest {

    @Autowired
    PaymentRepository paymentRepository;

    @Test
    @Transactional
    public void getPaymentById(){
        Payment payment = paymentRepository.getReferenceById(1);
        assertNotNull(payment);
        Double expected = 500.0;
        Double actual = payment.getBonus().doubleValue();
        Assertions.assertEquals(expected,actual);
        System.out.println(payment);
    }
}
