package com.smartsigma.telda.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.sql.results.graph.Fetch;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "customer_serviceid")
public class CustomerService extends Staff {

    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private Language language;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerService", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "customerService_request")
    private List<Request> requests;

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;

    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


}
