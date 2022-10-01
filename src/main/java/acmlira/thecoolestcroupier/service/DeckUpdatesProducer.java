package acmlira.thecoolestcroupier.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@CommonsLog
public class DeckUpdatesProducer {

    @Value("deckUpdates")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message){
        log.info("Sending " + message + " to " + topicName);
        kafkaTemplate.send(topicName, message);
    }

}
