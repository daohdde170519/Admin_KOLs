/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Repository;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.Entity.KolRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KolRegistrationRepository extends JpaRepository<KolRegistration, Long> {
}

