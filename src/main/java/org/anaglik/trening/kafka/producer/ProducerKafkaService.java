package org.anaglik.trening.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class ProducerKafkaService {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Value(value = "${kafka.topic.name}")
	private String topicName;

	@Value(value = "${partitioned.topic.name}")
	private String partitionedTopicName;

	public ProducerKafkaService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@SuppressWarnings("unchecked")
	public void sendMessage(String msg) {
		kafkaTemplate.send(topicName, msg);
	}

	public void sendMessageToPartition(String message, int partition) {
		kafkaTemplate.send(partitionedTopicName, partition, null, message);
	}
}
