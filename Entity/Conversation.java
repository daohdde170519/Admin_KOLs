/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Entity;

/**
 *
 * @author DAO
 */
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_conversation")
public class Conversation {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "created_at")
    private ZonedDateTime CreatedAt;
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;
    @Column(name = "lastMessage")
    private String lastMessage;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TypeConversation type;
}
