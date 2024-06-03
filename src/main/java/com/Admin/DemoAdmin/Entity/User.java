/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Entity;

/**
 *
 * @author DAO
 */
import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Column(length = 255, nullable = false)
    private String passwordHash;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 6, nullable = false)
    private String gender;

    @Column(name = "is_locked")
    private boolean locked;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "what_role", length = 20, nullable = false)
    private String role;

    // Getters and setters
}