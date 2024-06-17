/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service.Impl;

import com.Admin.DemoAdmin.Entity.KolRegistration;
import com.Admin.DemoAdmin.Repository.KolRegistrationRepository;
import com.Admin.DemoAdmin.Service.KolRegistrationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAO
 */
@Service
public class KolRegistrationServiceImpl implements KolRegistrationService{

    @Autowired
    private KolRegistrationRepository kolRegistrationRepository;
        
    @Override
    public List<KolRegistration> getAllRegistrations() {
        return kolRegistrationRepository.findAll();
    }

    @Override
    public void saveRegistration(KolRegistration registration) {
        kolRegistrationRepository.save(registration);
    }

    @Override
    public Optional<KolRegistration> getRegistrationById(Long id) {
        return kolRegistrationRepository.findById(id);
    }

    @Override
    public void deleteRegistration(Long id) {
        kolRegistrationRepository.deleteById(id);
    }
    
}
