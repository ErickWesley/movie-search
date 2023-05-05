package tumnus.com.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tumnus.com.movie.client.MovieClientOMDBFeign;
import vo.MovieOMDB;

@Service
public class MovieService {

    @Value("${imdb.apikey}")
    private String apikey;

    @Autowired
    private MovieClientOMDBFeign movieClientFeign;

    public MovieOMDB getMovie(String theme) {
        return movieClientFeign.getMovie(theme, apikey);
    }

}
