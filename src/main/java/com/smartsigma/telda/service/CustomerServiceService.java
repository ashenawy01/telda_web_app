package com.smartsigma.telda.service;

import com.smartsigma.telda.entity.CustomerService;
import com.smartsigma.telda.repository.CustomerServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerServiceService {
    private CustomerServiceRepository customerServiceRepository;

    public CustomerService save (CustomerService customerService) throws Exception{
        return customerServiceRepository.save(customerService);
    }
    public CustomerService findById(long id) throws Exception {
        return customerServiceRepository.findById(id).orElse(null);
    }
    public CustomerService findByEmail(String email) throws Exception {
        CustomerService customerService = customerServiceRepository.findByEmail(email);
        if (customerService == null) {
//            throw new UsernameNotFoundException("Customer service user not found!");
        }
        return customerService;
    }
    public List<CustomerService> findAll() {
        return customerServiceRepository.findAll();
    }
    public CustomerService update(CustomerService customerService) throws Exception {
        return customerServiceRepository.save(customerService);
    }
    public boolean deleteById(long id) throws Exception {
        if (findById(id) == null) {
//            throw new UsernameNotFoundException("Customer service user not found!");
        }
        customerServiceRepository.deleteById(id);
        return true;
    }


//    private UserDetails buildUserDetails(Admin admin, List<GrantedAuthority> authorities) {
//        return new User(admin.getEmail(), admin.getPassword(), admin.isActive(), true, true, true, authorities);
//    }
//
//    private List<GrantedAuthority> buildAuthorities(List<Role> roles) {
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Admin admin = adminRepository.findAdminByEmail(email);
//        if (admin == null) {
//            throw new UsernameNotFoundException("Invalid email or password.");
//        }
//        List<GrantedAuthority> authorities = buildAuthorities(admin.getRoles());
//        return buildUserDetails(admin, authorities);
//    }
}
