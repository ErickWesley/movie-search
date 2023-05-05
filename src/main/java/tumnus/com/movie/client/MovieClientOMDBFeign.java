package tumnus.com.movie.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vo.MovieOMDB;

@FeignClient(value = "omdbmovies", url = "http://www.omdbapi.com/")
public interface MovieClientOMDBFeign {

    @RequestMapping(method = RequestMethod.GET)
    MovieOMDB getMovie(@RequestParam("t") String theme, @RequestParam("apikey") String key);


}
