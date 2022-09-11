package acmlira.thecoolestcroupier.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Deck {
    @JsonProperty("deckId")
    private UUID deckId;
    @JsonProperty("cards")
    private List<Card> cards;
}
