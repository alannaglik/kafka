package org.anaglik.trening.kafka.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@PropertySource("classpath:application.properties")
public class ProducerKafkaService {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Value("${kafka.topic.name}")
	private String topicName;

	public ProducerKafkaService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}


	public void sendMessage(String msg) {
		String now = DateTimeFormatter.ISO_LOCAL_TIME.format(LocalDateTime.now());
		kafkaTemplate.send(topicName, msg + " " + now);
	}
}
