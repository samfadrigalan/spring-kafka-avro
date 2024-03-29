package com.code.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import com.rishav.avro.StudentActivity;
import com.dumbo.avro.People;

public class Receiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }

  @KafkaListener(topics = "${kafka.topic.avro}")
  public void receive(ConsumerRecord<String, People> record) {
    String key = record.key();
    LOGGER.info("received people, offset = {}, key = {}, value = {}", record.offset(), key, record.value());
  }
}
