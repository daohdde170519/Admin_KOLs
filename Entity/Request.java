/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Admin.DemoAdmin.Entity;

/**
 *
 * @author DAO
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Requests")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private int requestId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id")
    private User requester;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responder_id", nullable = true)
    private User responder;

    @Column(name = "request_description", columnDefinition = "NVARCHAR(MAX)", nullable = true)
    private String requestDescription;

    @Column(name = "request_location", length = 80, nullable = true, columnDefinition = "NVARCHAR(MAX)")
    private String requestLocation;

    @Column(name = "payment", nullable = true)
    private double payment;

    @Column(name = "request_date", nullable = true)
    private Date requestDate;

    @Column(name = "request_date_end", nullable = true)
    private Date requestDateEnd;

    @Column(name = "request_status")
    private RequestStatus requestStatus;

    @Column(name = "is_public")
    private boolean isPublic;

    @Column(name = "requester_confirm")
    private boolean requesterConfirm;

    @Column(name = "responer_confirm")
    private boolean responderConfirm;

    @Column(name="request_type")
    private String requestType;
    // Chá»‰ sá»­ dá»¥ng cho loáº¡i "HIREBYDAY"
    @ElementCollection
    @CollectionTable(name = "DayRequest", joinColumns = @JoinColumn(name = "request_id"))
    @Column(name = "day_request")
    private List<Date> daysRequest = new ArrayList<>();

    // Chá»‰ sá»­ dá»¥ng cho loáº¡i "REPRESENTATIVE"
    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RequestRepresentative requestRepresentative;

    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TransactionHistory transactionHistory;
}