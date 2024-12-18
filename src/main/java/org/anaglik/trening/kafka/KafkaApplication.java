package org.anaglik.trening.kafka;

import org.anaglik.trening.kafka.config.KafkaProduceConfig;
import org.anaglik.trening.kafka.producer.ProducerKafkaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				KafkaProduceConfig.class,
				ProducerKafkaService.class);

		context.getBean(ProducerKafkaService.class)
				.sendMessage("TESTOWA ");  //OK

	}
}
