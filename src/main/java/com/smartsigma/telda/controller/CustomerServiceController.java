package com.smartsigma.telda.controller;

import com.smartsigma.telda.entity.CustomerService;
import com.smartsigma.telda.service.CustomerServiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/service")
public class CustomerServiceController {

    private CustomerServiceService customerServiceService;

    @PostMapping("/customer-services")
    public CustomerService createCustomerService(@RequestBody CustomerService customerService) throws Exception {
        return customerServiceService.save(customerService);
    }

    @GetMapping("/customer-services")
    public List<CustomerService> getCustomerServices() {
        return customerServiceService.findAll();
    }

    @GetMapping("/customer-services/{id}")
    public CustomerService getCustomerService(@PathVariable long id) throws Exception {
        return customerServiceService.findById(id);
    }

    @GetMapping("/customer-services/email/{email}")
    public CustomerService getCustomerService(@PathVariable String email) throws Exception {
        return customerServiceService.findByEmail(email);
    }

    @PutMapping("/customer-services/{id}")
    public CustomerService updateCustomerService(@PathVariable long id,
                                                 @RequestBody CustomerService customerService) throws Exception {
        CustomerService oldCustomerService =
                customerServiceService.findById(id);
        if (oldCustomerService == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Service user not found!");
        }
        return customerServiceService.update(customerService);
    }
    @DeleteMapping("/customer-services/{id}")
    public void deleteCustomerService(@PathVariable long id) throws Exception {
        CustomerService oldCustomerService =
                customerServiceService.findById(id);
        if (oldCustomerService == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Service user not found!");
        }
        customerServiceService.deleteById(id);
    }

}

