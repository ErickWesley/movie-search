package vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MovieOMDB {

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;

    @JsonProperty("imdbRating")
    private String imdbRating;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Poster")
    private String poster;

}
