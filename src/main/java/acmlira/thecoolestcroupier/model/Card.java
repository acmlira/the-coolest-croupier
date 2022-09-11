package acmlira.thecoolestcroupier.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Card {
    @JsonProperty("code")
    private String code;
    @JsonProperty("value")
    private String value;
    @JsonProperty("suit")
    private String suit;
}