package acmlira.thecoolestcroupier.service;

import acmlira.thecoolestcroupier.mock.DeckMock;
import acmlira.thecoolestcroupier.mock.DrawMock;
import acmlira.thecoolestcroupier.model.Deck;
import acmlira.thecoolestcroupier.model.Draw;
import acmlira.thecoolestcroupier.repository.DeckRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.when;

@ExtendWith(MockitoExtension.class)
public class DrawServiceTest {

    @InjectMocks
    private DrawService drawService;

    @Mock
    private DeckRepository deckRepository;

    @Test
    public void shouldCreateDraw() {
        Deck deck = DeckMock.getDeck();
        Draw draw = DrawMock.getDraw();

        when(deckRepository.findById(any())).thenReturn(deck);
        when(deckRepository.save(any())).thenReturn(deck);

        assertEquals(drawService.create(draw), draw);
    }
}
