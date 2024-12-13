package org.anaglik.trening.kafka.consument;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;

//@AllArgsConstructor
public class ConsumerKafkaService {

	private final ConsumerFactory consumerFactory;

	public ConsumerKafkaService(ConsumerFactory consumerFactory) {
		this.consumerFactory = consumerFactory;
	}

	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${consumerFactory.getConfigurationProperties().get(ConsumerConfig.GROUP_ID_CONFIG).toString()}" )
	public void listenGroupFoo(String message) {
		System.out.println("Received Message in group foo: " + message);
	}

}
