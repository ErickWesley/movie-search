package tumnus.com.movie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {

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
