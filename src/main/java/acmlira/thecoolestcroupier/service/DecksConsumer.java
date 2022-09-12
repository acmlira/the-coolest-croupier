package acmlira.thecoolestcroupier.service;

import acmlira.thecoolestcroupier.dto.DeckDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@CommonsLog(topic = "Consumer Logger")
public class DecksConsumer {

    @Value("${app.kafka.topic.name.consumer}")
    private String topicName;

    @KafkaListener(topics = "decks", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> record) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            DeckDTO deckDTO = mapper.readValue(record.value(), DeckDTO.class);
            log.info(String.format("Consumed message -> %s", deckDTO.getDeckId()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}