package com.example.school.kafka;

import com.example.school.FullSchoolResponse;
import com.example.school.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class TestProducer {
    private final KafkaTemplate<String, FullSchoolResponse> kafkaTemplate;
    public void sendTestConfirmation(FullSchoolResponse fullSchoolResponse) {
        log.info("Sending confirmation");
        Message<FullSchoolResponse> message = MessageBuilder
                .withPayload(fullSchoolResponse)
                .setHeader(TOPIC, "test-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
