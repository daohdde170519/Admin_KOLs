/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Service.Impl;

import com.Admin.DemoAdmin.Entity.ViolationWord;
import com.Admin.DemoAdmin.Repository.ViolationWordRepository;
import com.Admin.DemoAdmin.Service.ViolationWordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAO
 */
@Service
public class ViolationWordServiceImpl implements ViolationWordService {

    @Autowired
    private ViolationWordRepository violationWordRepository;

    @Override
    public ViolationWord findById(int id) {
        return violationWordRepository.findById(id).orElse(null);
    }

    @Override
    public List<ViolationWord> findAll() {
        return violationWordRepository.findAll();
    }

    @Override
    public String saveViolationWord(ViolationWord violationWord) {
        boolean isDuplicate = checkDuplicateViolationWord(violationWord);
        if (isDuplicate) {
            return "Duplicate violation word";
        }
        violationWordRepository.save(violationWord);
        return "Success";
    }

    @Override
    public void deleteById(int id) {
        violationWordRepository.deleteById(id);
    }
    
    @Override
    public Page<ViolationWord> findPaginated(Pageable pageable) {
        return violationWordRepository.findAll(pageable);
    }
    
    @Override
    public boolean checkDuplicateViolationWord(ViolationWord violationWord) {
        List<ViolationWord> existingViolationWords = violationWordRepository.findAll();
        for (ViolationWord existingViolationWord : existingViolationWords) {
            if (!existingViolationWord.getWordId().equals(violationWord.getWordId())
                    && existingViolationWord.getWord().equalsIgnoreCase(violationWord.getWord())) {
                return true;
            }
        }
        return false;
    }
}
