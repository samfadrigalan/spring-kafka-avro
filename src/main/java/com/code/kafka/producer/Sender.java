package com.code.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import com.rishav.avro.StudentActivity;

public class Sender {

  private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

  @Value("${kafka.topic.avro}")
  private String avroTopic;

  @Autowired
  private KafkaTemplate<String, StudentActivity> kafkaTemplate;

  public void send(StudentActivity studentActivity) {
    LOGGER.info("sending student activity='{}'", studentActivity.toString());
    kafkaTemplate.send(avroTopic, studentActivity);
  }
}
