//package com.code.kafka;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Before;
//import org.junit.ClassRule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
//import org.springframework.kafka.listener.MessageListenerContainer;
//import org.springframework.kafka.test.rule.KafkaEmbedded;
//import org.springframework.kafka.test.utils.ContainerTestUtils;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.code.kafka.consumer.Receiver;
//import com.code.kafka.producer.Sender;
//
//import com.rishav.avro.StudentActivity;
//import com.rishav.avro.Activity;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ApplicationTest {
//
//  @Autowired
//  private Sender sender;
//
//  @Autowired
//  private Receiver receiver;
//
//  @Autowired
//  private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
//
//  @ClassRule
//  public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, "avro.t");
//
//  @Before
//  public void setUp() throws Exception {
//    // wait until the partitions are assigned
//    for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
//        .getListenerContainers()) {
//      ContainerTestUtils.waitForAssignment(messageListenerContainer,
//          embeddedKafka.getPartitionsPerTopic());
//    }
//  }
//
//  @Test
//  public void testReceiver() throws Exception {
//    Activity activity = Activity.newBuilder()
//                                  .setCourseId(123)
//                                  .setEnrollDate("20180804")
//                                  .setVerb("verb1")
//                                  .setResultScore(100.0)
//                                  .build();
//    StudentActivity user = StudentActivity.newBuilder()
//                                  .setId("id1")
//                                  .setName("John Doe")
//                                  .setUniversityId(345)
//                                  .setCourseDetails(activity)
//                                  .build();
//    sender.send(user);
//
//    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//    assertThat(receiver.getLatch().getCount()).isEqualTo(0);
//  }
//}
