package com.code.kafka.web;

import com.code.kafka.consumer.Receiver;
import com.code.kafka.dto.ActivityDTO;
import com.code.kafka.dto.StudentActivityDTO;
import com.code.kafka.producer.Sender;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rishav.avro.StudentActivity;
import com.rishav.avro.Activity;

import javax.validation.Valid;

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

    @ApiOperation(value = "Post Message")
    @PostMapping(path = "postMessage")
    public String postMessage(@Valid @RequestBody StudentActivityDTO studentActivityDTO) {
        ActivityDTO activityDTO = studentActivityDTO.getCourseDetails();
        Activity activity = Activity.newBuilder()
                .setCourseId(activityDTO.getCourseId())
                .setEnrollDate(activityDTO.getEnrollDate())
                .setVerb(activityDTO.getVerb())
                .setResultScore(activityDTO.getResultScore())
                .build();
        StudentActivity studentActivity = StudentActivity.newBuilder()
                .setId(studentActivityDTO.getId())
                .setName(studentActivityDTO.getName())
                .setUniversityId(studentActivityDTO.getUniversityId())
                .setCourseDetails(activity)
                .build();
        this.sender.send(studentActivity);
        return "hello";
    }
}