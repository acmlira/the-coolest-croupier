package acmlira.thecoolestcroupier.service;

import acmlira.thecoolestcroupier.client.TheCoolestShufflerClient;
import acmlira.thecoolestcroupier.model.Deck;
import acmlira.thecoolestcroupier.model.Draw;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@CommonsLog
public class DrawService {

    @Autowired
    private TheCoolestShufflerClient theCoolestShufflerClient;

    public Draw create(Draw draw) {
        Deck deck = theCoolestShufflerClient.findDeckById(draw.getDeckId());
        draw.setCards(deck.getCards().subList(0, draw.getCount()));
        deck.setCards(deck.getCards().subList(draw.getCount(), deck.getCards().size()));
        return draw;
    }
}
