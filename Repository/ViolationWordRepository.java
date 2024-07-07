/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Admin.DemoAdmin.Repository;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.Entity.ViolationWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViolationWordRepository extends JpaRepository<ViolationWord, Integer> {
}

