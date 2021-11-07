package com.codegym.service;

import com.codegym.entity.Notification;
import com.codegym.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationService implements INotificationService{
    @Autowired
    NotificationRepo notificationRepo;
    @Override
    public Iterable<Notification> findAll() {
        return notificationRepo.findAll();
    }

    @Override
    public Optional<Notification> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepo.save(notification);
    }

    @Override
    public void remove(Long id) {

    }
}
