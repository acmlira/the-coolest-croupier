package acmlira.thecoolestcroupier.model;

import acmlira.thecoolestcroupier.dto.CardDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Draw {
    private UUID deckId;
    private int count;
    private List<CardDTO> cardDTOS;
}
