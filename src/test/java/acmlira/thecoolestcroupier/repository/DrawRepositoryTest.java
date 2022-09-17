package acmlira.thecoolestcroupier.repository;

import acmlira.thecoolestcroupier.mock.DeckMock;
import acmlira.thecoolestcroupier.model.Deck;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.when;

@ExtendWith(MockitoExtension.class)
public class DrawRepositoryTest {
    @InjectMocks
    private DeckRepository deckRepository;

    @Mock
    private RedisTemplate redisTemplate;

    @Mock
    private HashOperations hashOperations;

    @Test
    public void shouldSave() {
        Deck deck = DeckMock.getDeck();

        when(redisTemplate.opsForHash()).thenReturn(hashOperations);

        assertEquals(deck, deckRepository.save(deck));
    }

    @Test
    public void shouldNotFindById() {
        Deck deck = DeckMock.getDeck();

        when(redisTemplate.opsForHash()).thenReturn(hashOperations);

        assertNull(deckRepository.findById(deck.getDeckId()));
    }

    @Test
    public void shouldFindAll() {
        when(redisTemplate.opsForHash()).thenReturn(hashOperations);

        assertEquals(0, deckRepository.findAll().size());
    }

    @Test
    public void shouldDelete() {
        Deck deck = DeckMock.getDeck();

        when(redisTemplate.opsForHash()).thenReturn(hashOperations);

        assertEquals(0, deckRepository.delete(deck.getDeckId()));
    }
}
