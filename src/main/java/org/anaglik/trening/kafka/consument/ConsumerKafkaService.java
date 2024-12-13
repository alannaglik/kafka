package org.anaglik.trening.kafka.consument;

import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ConsumerKafkaService {

	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${config.group.id}", containerFactory = "kafkaListenerContainerFactory")
	public void listen(String message) {
		System.out.println("Received Message: " + message);
	}

}
