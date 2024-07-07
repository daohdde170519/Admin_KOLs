/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Repository;

import com.Admin.DemoAdmin.Entity.TransactionHistory;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DAO
 */
@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Integer> {
    List<TransactionHistory> findByTransDateBetween(Date startDate, Date endDate);

    @Query("SELECT DISTINCT YEAR(th.transDate) FROM TransactionHistory th WHERE th.transPayment > 0 AND th.transtStatus = true")
    List<Integer> findYearsWithPayment();
}
