package acmlira.thecoolestcroupier;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TheCoolestCroupierApplication {
	@Value("${app.kafka.topic.name.consumer}")
	private String topicName;

	@Value("${app.kafka.topic.partitions-num}")
	private Integer partitions;

	@Value("${app.kafka.topic.replication-factor}")
	private short replicationFactor;

	@Bean
	NewTopic decksTopic() {
		return new NewTopic(topicName, partitions, replicationFactor);
	}

	public static void main(String[] args) {
		SpringApplication.run(TheCoolestCroupierApplication.class, args);
	}

}
