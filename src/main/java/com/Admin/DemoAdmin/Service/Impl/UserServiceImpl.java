/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service.Impl;

import com.Admin.DemoAdmin.DTOs.UserDTO;
import com.Admin.DemoAdmin.Entity.Gender;
import com.Admin.DemoAdmin.Entity.User;
import com.Admin.DemoAdmin.Mapper.UserMapper;
import com.Admin.DemoAdmin.Repository.UserRepository;
import com.Admin.DemoAdmin.Service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAO
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUserDTOs() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }
    @Override
    public Page<UserDTO> findPaginated(Pageable pageable) {
        Page<User> usersPage = userRepository.findAll(pageable);
        return usersPage.map(user -> userMapper.toUserDTO(user));
    }

    @Override
    public UserDTO getUserDTOById(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return userMapper.toUserDTO(user);
        }
        return null;
    }
    
    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getUserId());
        userDTO.setName(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setGender(user.getGender().toString());
        userDTO.setRole(user.getRole());
        // Add more fields as needed
        return userDTO;
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }   

    @Override
    public Page<User> pageUsers(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo,10);
        Page<User> userPage = userRepository.pageUser(pageable);
        return userPage;
    }
    
    @Override
    public Page<UserDTO> searchUsers(String keyword, Gender gender, Pageable pageable) {
         return userRepository.searchUsers(keyword, gender, pageable).map(userMapper::toUserDTO);
    }

    @Override
    public Page<UserDTO> searchUsersWithBan(String keyword, Gender gender, Pageable pageable) {
        return userRepository.searchUsersWithBan(keyword, gender, pageable).map(userMapper::toUserDTO);
    }
    
    @Override
    public Page<UserDTO> searchUsersWithUnBan(String keyword, Gender gender, Pageable pageable) {
        return userRepository.searchUsersWithUnBan(keyword, gender, pageable).map(userMapper::toUserDTO);
    }
    
    @Override
    public List<Long> getUserCountByMonthAndYear(int year) {
        List<Object[]> results = userRepository.findUserCountByMonthAndYear(year);
        List<Long> userCounts = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            userCounts.add(0L); 
        }
        for (Object[] result : results) {
            Long count = (Long) result[0];
            int month = (int) result[1];
            userCounts.set(month - 1, count);
        }
        return userCounts;
    }
    
    
    @Override
    public List<Integer> getYearsWithUsers() {
        return userRepository.findYearsWithUsers();
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
    
    public void saveUser(User user) {
        userRepository.save(user);
    }
}