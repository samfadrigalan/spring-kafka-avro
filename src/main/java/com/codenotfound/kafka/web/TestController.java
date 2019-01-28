package com.codenotfound.kafka.web;

import com.codenotfound.kafka.consumer.Receiver;
import com.codenotfound.kafka.producer.Sender;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
public class TestController {

    private Sender sender;
    private Receiver receiver;

    @Autowired
    public TestController(Sender sender, Receiver receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    @ApiOperation(value = "Send Message")
    @GetMapping
    public String sendMessage() {
        return "Hello";
    }
}