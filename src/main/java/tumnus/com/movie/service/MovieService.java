package tumnus.com.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tumnus.com.movie.client.MovieClientOMDBFeign;
import tumnus.com.movie.dto.Request;
import tumnus.com.movie.dto.Response;
import tumnus.com.movie.model.Movie;
import tumnus.com.movie.repository.MovieRepository;
import vo.MovieOMDB;

@Service
public class MovieService {

    @Value("${imdb.apikey}")
    private String apikey;

    @Autowired
    private MovieClientOMDBFeign movieClientFeign;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private Response response;

    public MovieOMDB getMovie(String theme) {
        return movieClientFeign.getMovie(theme, apikey);
    }

    public Movie save(Request request) {
        Movie movie = response.convertForMovie(request);
        return movieRepository.save(movie);
    }
    public Movie getById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Non-existent Movie"));
    }

}
