/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Admin.DemoAdmin.Service;

import com.Admin.DemoAdmin.Entity.KolRegistration;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAO
 */
@Service
public interface KolRegistrationService{
    List<KolRegistration> getAllRegistrations();
    void saveRegistration(KolRegistration registration);
    Optional<KolRegistration> getRegistrationById(Long id);
    void deleteRegistration(Long id);
}
