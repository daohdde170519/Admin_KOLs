/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Admin.DemoAdmin.Service;

import com.Admin.DemoAdmin.Entity.TransactionHistory;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAO
 */
@Service
public interface TransactionHistoryService {
List<Double> getTotalPaymentPerMonth(int year);
List<Integer> getYearsWithPayment();
}
