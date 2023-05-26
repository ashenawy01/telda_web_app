package com.smartsigma.telda.service;

import com.smartsigma.telda.entity.Client;
import com.smartsigma.telda.entity.CustomerService;
import com.smartsigma.telda.entity.Request;
import com.smartsigma.telda.entity.RequestId;
import com.smartsigma.telda.repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RequestService {
    private RequestRepository requestRepository;

    public Request save(Request request) {
        return requestRepository.save(request);
    }
    public List<Request> customerServiceRequests(CustomerService customerService) {
        return requestRepository.findByCustomerService(customerService);
    }
    public List<Request> clientRequests(Client client) {
        return requestRepository.findByClient(client);
    }
    public List<Request> findAll() {
        return requestRepository.findAll();
    }
    public Request updateRequest(Request request){
        return requestRepository.save(request);
    }
    public boolean deleteRequestById(RequestId requestId) {
        requestRepository.deleteById(requestId);
        return true;
    }
}
