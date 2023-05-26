package com.smartsigma.telda.repository;

import com.smartsigma.telda.entity.Client;
import com.smartsigma.telda.entity.CustomerService;
import com.smartsigma.telda.entity.Request;
import com.smartsigma.telda.entity.RequestId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, RequestId> {
    List<Request> findByClient(Client client);
    List<Request> findByCustomerService(CustomerService customerService);

}
