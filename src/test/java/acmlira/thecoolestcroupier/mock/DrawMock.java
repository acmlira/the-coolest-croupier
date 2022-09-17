package acmlira.thecoolestcroupier.mock;

import acmlira.thecoolestcroupier.model.Draw;

public class DrawMock {
    public static Draw getDraw() {
        Draw draw = new Draw();
        draw.setCount(CardMock.getListOfCards().size());
        draw.setCards(CardMock.getListOfCards());

        return draw;
    }
}
