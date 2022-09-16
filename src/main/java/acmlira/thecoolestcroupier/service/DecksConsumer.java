package acmlira.thecoolestcroupier.service;

import acmlira.thecoolestcroupier.dto.DeckDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@CommonsLog
public class DecksConsumer {
    @KafkaListener(topics = "decks")
    public void consume(ConsumerRecord<String, String> record) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            DeckDTO deckDTO = mapper.readValue(record.value(), DeckDTO.class);
            log.info("DeckId: " + deckDTO.getDeckId());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}