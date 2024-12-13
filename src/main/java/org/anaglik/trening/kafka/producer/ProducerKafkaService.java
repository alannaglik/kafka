package org.anaglik.trening.kafka.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;

@Component
@PropertySource("classpath:application.properties")
public class ProducerKafkaService {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Value("${kafka.topic.name}")
	private String topicName;

	public ProducerKafkaService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@SuppressWarnings("unchecked")
	public void sendMessage(String msg) {
		String now = DateTimeFormatter.ISO_LOCAL_TIME.format(LocalDateTime.now());
		kafkaTemplate.send(topicName, msg + " " + now);
	}

//	public void sendMessageToPartition(String message, int partition) {
//		System.out.println("Wysylam wiadomosc: " + message + " na partycje: " + partition);
//		kafkaTemplate.send(topicName, partition, "dupa", message);
//		System.out.println("Zakonczylem wysylke");
//	}
//
//	public void sendMessage1(String message) {
//		CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("Topic1", message);
//		future.whenComplete((result, ex) -> {
//			if (ex == null) {
//				System.out.println("Sent message=[" + message +
//						"] with offset=[" + result.getRecordMetadata().offset() + "]");
//			} else {
//				System.out.println("Unable to send message=[" +
//						message + "] due to : " + ex.getMessage());
//			}
//		});
//	}
}
