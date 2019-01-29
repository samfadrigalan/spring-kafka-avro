package com.code.kafka.web;

import com.code.kafka.consumer.Receiver;
import com.code.kafka.producer.Sender;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishav.avro.StudentActivity;
import com.rishav.avro.Activity;

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
        Activity activity = Activity.newBuilder()
                .setCourseId(123)
                .setEnrollDate("20180804")
                .setVerb("verb1")
                .setResultScore(100.0)
                .build();
        StudentActivity studentActivity = StudentActivity.newBuilder()
                .setId("id1")
                .setName("John Doe")
                .setUniversityId(345)
                .setCourseDetails(activity)
                .build();
        this.sender.send(studentActivity);
        return "hello";
    }
}
