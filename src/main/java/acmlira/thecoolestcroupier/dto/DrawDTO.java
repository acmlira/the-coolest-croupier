package acmlira.thecoolestcroupier.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class DrawDTO {
    private UUID deckId;
    private int count;
    private List<CardDTO> cards;
}
