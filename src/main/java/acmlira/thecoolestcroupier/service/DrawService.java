package acmlira.thecoolestcroupier.service;

import acmlira.thecoolestcroupier.model.Draw;
import acmlira.thecoolestcroupier.model.Deck;
import acmlira.thecoolestcroupier.repository.DeckRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@CommonsLog
public class DrawService {

    @Autowired
    private DeckRepository deckRepository;

    public Draw create(Draw draw) {
        Deck deck = deckRepository.findById(draw.getDeckId());
        draw.setCards(deck.getCards().subList(0, draw.getCount()));
        deck.setCards(deck.getCards().subList(draw.getCount(), deck.getCards().size()));
        deckRepository.save(deck);
        return draw;
    }
}
