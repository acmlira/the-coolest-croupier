package acmlira.thecoolestcroupier.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class CardDTO {
    @JsonProperty("code")
    private String code;
    @JsonProperty("value")
    private String value;
    @JsonProperty("suit")
    private String suit;
}