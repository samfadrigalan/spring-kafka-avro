package com.code.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import com.rishav.avro.StudentActivity;
import com.dumbo.avro.People;
public class Sender {

  private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

  @Value("${kafka.topic.avro}")
  private String avroTopic;

  @Autowired
  private KafkaTemplate<String, People> kafkaTemplate;

  public void send(People people) {
    LOGGER.info("sending people='{}'", people.toString());
    kafkaTemplate.send(avroTopic, "key1", people);
  }
}
