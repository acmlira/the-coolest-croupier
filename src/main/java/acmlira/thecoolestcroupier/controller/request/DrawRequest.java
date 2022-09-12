package acmlira.thecoolestcroupier.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class DrawRequest {
    private UUID deckId;
    private int count;
}
