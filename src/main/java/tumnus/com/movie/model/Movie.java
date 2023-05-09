package tumnus.com.movie.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date_create")
    private String year;

    @Column(name = "imdbRating")
    private String imdbRating;

    @Column(name = "plot")
    private String plot;

    @Column(name = "poster")
    private String poster;


}
