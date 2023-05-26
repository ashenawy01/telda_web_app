package com.smartsigma.telda.repository;

import com.smartsigma.telda.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    public Admin findAdminByEmail(String email);
}
