package com.smartsigma.telda.repository;

import com.smartsigma.telda.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
    Client findByPhoneNo(String phoneNo);
}
