package acmlira.thecoolestcroupier.mock;

import acmlira.thecoolestcroupier.model.Deck;

import java.util.UUID;

public class DeckMock {
    public static Deck getDeck() {
        Deck deck = new Deck();
        deck.setDeckId(UUID.randomUUID());
        deck.setCards(CardMock.getListOfCards());

        return deck;
    }
}
