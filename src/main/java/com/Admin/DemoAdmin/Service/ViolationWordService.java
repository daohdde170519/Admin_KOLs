/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Admin.DemoAdmin.Service;

/**
 *
 * @author DAO
 */
import com.Admin.DemoAdmin.Entity.ViolationWord;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ViolationWordService {
    
    ViolationWord findById(int id);
    
    List<ViolationWord> findAll();
        
    void deleteById(int id);
    
    Page<ViolationWord> findPaginated(Pageable pageable);
    
    boolean checkDuplicateViolationWord(ViolationWord biolationWord);
    
    String saveViolationWord(ViolationWord violationWord);
}

