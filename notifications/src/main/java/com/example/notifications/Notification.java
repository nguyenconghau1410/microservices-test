package com.example.notifications;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "notifications")
@Data
@Builder
public class Notification {
    private String id;
    private String name;
    private List<Student> students;
}
