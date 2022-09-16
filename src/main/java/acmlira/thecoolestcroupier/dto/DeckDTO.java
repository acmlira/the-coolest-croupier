package acmlira.thecoolestcroupier.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class DeckDTO {
    private UUID deckId;
    private List<CardDTO> cards;
}
