package com.smartsigma.telda.repository;

import com.smartsigma.telda.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
