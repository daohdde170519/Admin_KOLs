/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author DAO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryCountDTO {
    private String categoryName;
    private long count;

    // Getters and setters
}

