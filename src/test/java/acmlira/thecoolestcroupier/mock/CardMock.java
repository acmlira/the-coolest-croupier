package acmlira.thecoolestcroupier.mock;

import acmlira.thecoolestcroupier.model.Card;

import java.util.ArrayList;
import java.util.List;

public class CardMock {
    public static List<Card> getListOfCards() {
        List<Card> cards = new ArrayList<>();

        cards.add(getAceOfClubs());
        cards.add(getAceOfHearts());

        return cards;
    }

    public static Card getAceOfClubs() {
        Card card = new Card();
        card.setCode("AC");
        card.setSuit("CLUBS");
        card.setValue("ACE");
        return card;
    }

    public static Card getAceOfHearts() {
        Card card = new Card();
        card.setCode("AH");
        card.setSuit("HEARTS");
        card.setValue("ACE");
        return card;
    }
}
