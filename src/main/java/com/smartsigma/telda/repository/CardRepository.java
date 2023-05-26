package com.smartsigma.telda.repository;

import com.smartsigma.telda.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
