package com.smartsigma.telda.service;

import com.smartsigma.telda.entity.Admin;
import com.smartsigma.telda.entity.Role;
import com.smartsigma.telda.repository.AdminRepository;
import lombok.AllArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class AdminService {

    private AdminRepository adminRepository;

    public Admin save(Admin admin) throws Exception {
        if (admin == null) {
            throw new RuntimeException("Error with saving new Admin - Null object");
        }
        return adminRepository.save(admin);
    }

    public  List<Admin> findAll () {
        return adminRepository.findAll();
    }

    public Admin findById(long adminId) throws Exception{
        Admin admin = adminRepository.findById(adminId).orElse(null);
//        if (admin == null) {
//            throw new UsernameNotFoundException("Admin with ID: #" + adminId + " NOT FOUND");
//        }
        return admin;
    }

    public Admin findByEmail(String email) throws Exception{
        Admin admin = adminRepository.findAdminByEmail(email);
//        if (admin == null) {
//            throw new UsernameNotFoundException("Admin with email: # " + email + " NOT FOUND");
//        }
        return admin;
    }

    public Admin update(Admin newAdmin) {
        if (newAdmin.getId() < 1) {
            throw new RuntimeException("Failed to update - Invalid ID");
        }
        Admin admin = adminRepository.findById(newAdmin.getId()).orElse(null);
//        if (admin == null) {
//            throw new UsernameNotFoundException("Admin with ID: #" + newAdmin.getId() + " NOT FOUND");
//        }
        return adminRepository.save(newAdmin);
    }

    public boolean deleteAdmin(long adminId) {
        Admin admin = adminRepository.findById(adminId).orElse(null);
//        if (admin == null) {
//            throw new UsernameNotFoundException("Admin with ID: #" + adminId + " NOT FOUND");
//        }
        adminRepository.deleteById(adminId);
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
