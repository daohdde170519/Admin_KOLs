/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service.Impl;

import com.Admin.DemoAdmin.Entity.TransactionHistory;
import com.Admin.DemoAdmin.Repository.TransactionHistoryRepository;
import com.Admin.DemoAdmin.Service.TransactionHistoryService;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAO
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

@Override
public List<Double> getTotalPaymentPerMonth(int year) {
    List<Double> totalPayments = new ArrayList<>();
    Calendar calendar = Calendar.getInstance();
    for (int i = 0; i < 12; i++) {
        calendar.set(year, i, 1, 0, 0, 0);
        Date startDate = calendar.getTime();

        calendar.set(Calendar.MONTH, i + 1); // Đặt tháng tiếp theo
        if (i == 11) { // Đặt năm tiếp theo nếu là tháng cuối cùng của năm
            calendar.set(Calendar.YEAR, year + 1);
        }
        Date endDate = calendar.getTime();

        List<TransactionHistory> transactions = transactionHistoryRepository.findByTransDateBetween(startDate, endDate);
        double totalPayment = 0.0;
        for (TransactionHistory transaction : transactions) {
            if(transaction.isTranstStatus()){
            totalPayment += transaction.getTransPayment();}
        }
        totalPayments.add(totalPayment);
    }
    return totalPayments;
}

    @Override
    public List<Integer> getYearsWithPayment() {
        return transactionHistoryRepository.findYearsWithPayment();
    }
}
