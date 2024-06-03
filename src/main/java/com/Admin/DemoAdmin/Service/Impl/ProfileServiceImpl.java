
package com.Admin.DemoAdmin.Service.Impl;

import com.Admin.DemoAdmin.DTOs.ProfileDTO;
import com.Admin.DemoAdmin.DTOs.UserDTO;
import com.Admin.DemoAdmin.Entity.Profile;
import com.Admin.DemoAdmin.Entity.User;
import com.Admin.DemoAdmin.Mapper.ProfileMapper;
import com.Admin.DemoAdmin.Repository.ProfileRepository;
import com.Admin.DemoAdmin.Repository.UserRepository;
import com.Admin.DemoAdmin.Service.ProfileService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileMapper profileMapper;

    @Override
    public Profile findById(Integer userId) {
        return profileRepository.findById(userId).orElse(null);
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void deleteById(Integer userId) {
        profileRepository.deleteById(userId);
    }

    @Override
    public ProfileDTO getUserProfile(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        Profile profile = profileRepository.findById(userId).orElse(null);
        if (user != null && profile != null) {
            return profileMapper.toProfileDTO(user, profile);
        }
        return null;
    }

    @Override
    public void deleteProfileByUserId(Integer id) {
        profileRepository.deleteById(id);
    }
}
