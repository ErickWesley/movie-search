package vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class MovieVO extends RepresentationModel<MovieVO> {

    private Long id;
    private String title;
    private String year;
    private String imdbRating;
    private String plot;
    private String poster;


}
