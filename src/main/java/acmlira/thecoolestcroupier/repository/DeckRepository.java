package acmlira.thecoolestcroupier.repository;

import acmlira.thecoolestcroupier.model.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@EnableAutoConfiguration
@EnableRedisRepositories
public class DeckRepository {
    public static final String HASH_KEY = "Deck";

    @Autowired
    private RedisTemplate redisTemplate;

    public Deck save(Deck deck) {
        redisTemplate.opsForHash().put(HASH_KEY, deck.getDeckId(), deck);
        return deck;
    }

    public List<Deck> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Deck findById(UUID id) {
        return (Deck) redisTemplate.opsForHash().get(HASH_KEY,id);
    }

    public Long delete(UUID id){
        return redisTemplate.opsForHash().delete(HASH_KEY,id);
    }
}
