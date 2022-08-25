package com.works.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageRestController {

    final JmsTemplate jmsTemplate;

    @GetMapping("/message")
    public String message() {
        jmsTemplate.convertAndSend("New Send Message");
        return "";
    }

}
