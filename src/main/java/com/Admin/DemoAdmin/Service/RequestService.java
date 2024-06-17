/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Admin.DemoAdmin.Service;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAO
 */
@Service
public interface RequestService {
List<String> getUsernamesByFilters(Double minPayment, Double maxPayment, String location,
                                              Date startDate, Date endDate, Integer categoryId);
}
