/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service.Impl;


import com.Admin.DemoAdmin.Entity.Request;
import com.Admin.DemoAdmin.Entity.RequestStatus;
import com.Admin.DemoAdmin.Repository.RequestRepository;
import com.Admin.DemoAdmin.Service.RequestService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAO
 */
@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepository requestRepository;
    
    @Override
    public List<Request> getFilteredRequests(List<String> requestTypes, String requestLocation) {
        // Set default request types if none are provided
        if (requestTypes == null || requestTypes.isEmpty()) {
            requestTypes = Arrays.asList("POST", "VIDEO", "HIREBYDAY", "REPRESENTATIVE");
        }
        RequestStatus requestStatus = RequestStatus.PENDING; // Or any other default status
        
        // If no location is provided, pass null
        if (requestLocation != null && requestLocation.trim().isEmpty()) {
            requestLocation = null;
        }
        // If no location is provided, pass null
        return requestRepository.findFilteredRequests(requestTypes, requestLocation, requestStatus);
    }
}
