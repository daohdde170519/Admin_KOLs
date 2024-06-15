/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.TransactionHistoryRepositoryTest;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.Entity.TransactionHistory;
import com.Admin.DemoAdmin.Entity.User;
import com.Admin.DemoAdmin.Repository.TransactionHistoryRepository;
import com.Admin.DemoAdmin.Repository.UserRepository;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // Sử dụng cơ sở dữ liệu thực thay vì in-memory
public class TransactionHistoryRepositoryTest {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    @Autowired
    private UserRepository userRepository; // Giả sử bạn có UserRepository

    @BeforeEach
    public void setup() {
        // Tạo dữ liệu mẫu cho test
        User sender = new User();
        sender.setUsername("test_sender");
        sender.setPasswordHash("hashed_password");
        sender.setEmail("test_sender@example.com");
        sender.setGender("Male");
        sender.setLocked(false);
        sender.setCreateAt(new Date());
        sender.setRole("User");
        userRepository.save(sender);

        User receiver = new User();
        receiver.setUsername("test_receiver");
        receiver.setPasswordHash("hashed_password");
        receiver.setEmail("test_receiver@example.com");
        receiver.setGender("Male");
        receiver.setLocked(false);
        receiver.setCreateAt(new Date());
        receiver.setRole("User");
        userRepository.save(receiver);

        TransactionHistory transaction1 = new TransactionHistory();
        transaction1.setTransPayment(1000);
        transaction1.setTransDate(new Date());
        transaction1.setSender(sender);
        transaction1.setReceiver(receiver);
        transaction1.setTranstStatus(true);
        transactionHistoryRepository.save(transaction1);

        TransactionHistory transaction2 = new TransactionHistory();
        transaction2.setTransPayment(2000);
        transaction2.setTransDate(new Date());
        transaction2.setSender(sender);
        transaction2.setReceiver(receiver);
        transaction2.setTranstStatus(true);
        transactionHistoryRepository.save(transaction2);
    }

    @Test
    @Rollback(false)
    public void testFindYearsWithPayment() {
        List<Integer> years = transactionHistoryRepository.findYearsWithPayment();
        System.out.println("Years with payment: " + years);
        assertFalse(years.isEmpty(), "Years with payment should not be empty");
    }
}
