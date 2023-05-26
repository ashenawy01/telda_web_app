package com.smartsigma.telda.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Request")
public class Request {

    @EmbeddedId
    private RequestId id;

    @Column(name = "join_date")
    private Timestamp joinDate;
    @Column(name = "nationalid_src")
    private String nationalIDSrc;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @MapsId("clientID")
    @JoinColumn(name = "client_id")
    @JsonBackReference(value = "client_request")
    private Client client;

    @ManyToOne
    @MapsId("customerServiceID")
    @JoinColumn(name = "customer_serviceid")
    @JsonBackReference(value = "customerService_request")
    private CustomerService customerService;

    public RequestId getId() {
        return id;
    }

    public void setId(RequestId id) {
        this.id = id;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    public String getNationalIDSrc() {
        return nationalIDSrc;
    }

    public void setNationalIDSrc(String nationalIDSrc) {
        this.nationalIDSrc = nationalIDSrc;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
