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
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RecentSearchHistory")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RecentSearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "search_id")
    private int searchId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "search_query", length = 255, nullable = false)
    private String searchQuery;

    @Column(name = "search_timestamp")
    private Date searchTimestamp;

    // Getters and setters
}

