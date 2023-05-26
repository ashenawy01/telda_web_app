package com.smartsigma.telda.repository;

import com.smartsigma.telda.entity.CustomerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerServiceRepository extends JpaRepository<CustomerService, Long> {
    public CustomerService findByEmail(String email);
}
