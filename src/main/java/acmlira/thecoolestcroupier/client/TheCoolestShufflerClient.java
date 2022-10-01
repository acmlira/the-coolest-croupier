package acmlira.thecoolestcroupier.client;

import acmlira.thecoolestcroupier.model.Deck;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(
        name = "theCoolestShuffler",
        url  = "localhost:8916/the-coolest-shuffler/v1"
)
public interface TheCoolestShufflerClient {

        @RequestMapping(method = RequestMethod.GET, value = "/deck/{deckId}")
        Deck findDeckById(@PathVariable UUID deckId);

}
