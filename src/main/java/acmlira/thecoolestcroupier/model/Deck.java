package acmlira.thecoolestcroupier.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("Deck")
public class Deck implements Serializable {
    @Id
    private UUID deckId;
    private List<Card> cards;

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
