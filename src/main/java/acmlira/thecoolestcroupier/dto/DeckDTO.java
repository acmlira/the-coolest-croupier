package acmlira.thecoolestcroupier.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class DeckDTO {
    @JsonProperty("deckId")
    private UUID deckId;
    @JsonProperty("cards")
    private List<CardDTO> cardDTOS;
}
