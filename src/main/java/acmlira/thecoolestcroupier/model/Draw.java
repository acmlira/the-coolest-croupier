package acmlira.thecoolestcroupier.model;

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
    private List<Card> cards;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Draw draw = (Draw) o;

        if (count != draw.count) return false;
        if (!deckId.equals(draw.deckId)) return false;
        return cards != null ? cards.equals(draw.cards) : draw.cards == null;
    }

    @Override
    public int hashCode() {
        int result = deckId.hashCode();
        result = 31 * result + count;
        result = 31 * result + (cards != null ? cards.hashCode() : 0);
        return result;
    }
}
