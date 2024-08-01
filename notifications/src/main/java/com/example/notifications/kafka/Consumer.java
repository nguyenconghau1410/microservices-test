package com.example.notifications.kafka;

import com.example.notifications.FullSchoolResponse;
import com.example.notifications.Notification;
import com.example.notifications.NotificationRepository;
import com.example.notifications.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class Consumer {

    private final NotificationRepository repository;

    @KafkaListener(topics = "test-topic", groupId = "test-group")
    public void received(FullSchoolResponse fullSchoolResponse) {
        System.out.println(fullSchoolResponse);
        repository.save(Notification.builder().name("Sinh viên Vaa").students(fullSchoolResponse.students()).build());
    }
}
