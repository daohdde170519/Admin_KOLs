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
@Table(name = "Profile")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Profile {
    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String bio;

    @Lob
    private byte[] avatar;

    private Date birthday;

    @Column(name = "phonenumber", length = 10)
    private String phoneNumber;

    @Column(length = 50)
    private String address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and setters
}