/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.DTOs.ProfileDTO;
import com.Admin.DemoAdmin.Entity.Profile;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService {

    Profile findById(Integer userId);

    List<Profile> findAll();

    Profile save(Profile profile);

    void deleteById(Integer userId);

    ProfileDTO getUserProfile(Integer userId);

    void deleteProfileByUserId(Integer id);
}
