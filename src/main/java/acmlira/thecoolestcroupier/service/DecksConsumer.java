package acmlira.thecoolestcroupier.service;

import acmlira.thecoolestcroupier.model.Deck;
import acmlira.thecoolestcroupier.repository.DeckRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@CommonsLog
@EnableKafka
public class DecksConsumer {

    @Autowired
    private DeckRepository deckRepository;

    @KafkaListener(topics = "decks")
    public void consume(ConsumerRecord<String, String> record) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Deck deck = mapper.readValue(record.value(), Deck.class);

            log.info("DeckId: " + deck.getDeckId());
            deckRepository.save(deck);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
