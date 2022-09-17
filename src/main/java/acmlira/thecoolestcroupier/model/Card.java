package acmlira.thecoolestcroupier.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Card implements Serializable {
    private String code;
    private String value;
    private String suit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (!code.equals(card.code)) return false;
        if (!value.equals(card.value)) return false;
        return suit.equals(card.suit);
    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + suit.hashCode();
        return result;
    }
}