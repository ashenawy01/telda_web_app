package com.smartsigma.telda.repository;

import com.smartsigma.telda.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}
