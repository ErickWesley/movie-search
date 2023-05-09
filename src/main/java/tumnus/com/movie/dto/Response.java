package tumnus.com.movie.dto;

import org.springframework.stereotype.Component;
import tumnus.com.movie.model.Movie;
import vo.MovieVO;

@Component
public class Response {

    public Movie convertForMovie(Request request) {
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setYear(request.getYear());
        movie.setPlot(request.getPlot());
        movie.setImdbRating(request.getImdbRating());
        movie.setPoster(request.getPoster());
        return movie;
    }

    public MovieVO convertForMovieVO(Movie movie) {
        MovieVO movieVO = new MovieVO();
        movieVO.setId(movie.getId());
        movieVO.setTitle(movie.getTitle());
        movieVO.setYear(movie.getYear());
        movieVO.setPlot(movie.getPlot());
        movieVO.setImdbRating(movie.getImdbRating());
        movieVO.setPoster(movie.getPoster());
        return movieVO;
    }


}
