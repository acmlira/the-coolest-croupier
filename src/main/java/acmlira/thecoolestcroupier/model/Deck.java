package acmlira.thecoolestcroupier.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Deck implements Serializable {
    private UUID deckId;
    private List<Card> cards;
    private Integer remaining;
    private Boolean shuffle;
    private Integer amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deck deck = (Deck) o;

        if (!deckId.equals(deck.deckId)) return false;
        return cards.equals(deck.cards);
    }

    @Override
    public int hashCode() {
        int result = deckId.hashCode();
        result = 31 * result + cards.hashCode();
        return result;
    }
}
