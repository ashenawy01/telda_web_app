package com.smartsigma.telda.controller;

import com.smartsigma.telda.entity.Admin;
import com.smartsigma.telda.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/telda")
public class AdminController {

    private AdminService adminService;

    @GetMapping("/admins")
    public List<Admin> getAllAdmins () {
        return adminService.findAll();
    }

    @GetMapping("/admins/{id}")
    public Admin getAdminById (@PathVariable long id) throws Exception {
        return adminService.findById(id);
    }

    @GetMapping("/admins/email/{email}")
    public Admin getAdminByEmail (@PathVariable String email) throws Exception {
        return adminService.findByEmail(email);
    }

    @PostMapping("/admins")
    public Admin createAdmin(@RequestBody Admin admin) throws Exception {
        return adminService.save(admin);
    }
    @PutMapping("/admins/{id}")
    public Admin updateAdmin(@RequestBody Admin admin, @PathVariable long id) throws Exception {
        Admin oldAdmin = adminService.findById(id);
        if (oldAdmin == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return adminService.update(admin);
    }
    @DeleteMapping("/admins/{id}")
    public void deleteAdmin(@PathVariable long id) throws Exception {
        Admin oldAdmin = adminService.findById(id);
        if (oldAdmin == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        if (!adminService.deleteAdmin(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Un expected Error with deleteing");
        }
    }

}
