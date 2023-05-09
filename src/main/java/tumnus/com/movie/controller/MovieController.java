package tumnus.com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tumnus.com.movie.dto.Request;
import tumnus.com.movie.dto.Response;
import tumnus.com.movie.service.MovieService;
import vo.MovieOMDB;
import vo.MovieVO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private Response response;

    @GetMapping("/omdb/{theme}")
    public ResponseEntity<MovieOMDB> getMovie(@PathVariable String theme) {
        try {
            MovieOMDB movieOMDB = movieService.getMovie(theme);
            return ResponseEntity.status(HttpStatus.OK).body(movieOMDB);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @PostMapping
    public ResponseEntity<MovieVO> saveMovie(@RequestBody Request request) {
        try {
            MovieVO movieVO = response.convertForMovieVO(movieService.save(request));
            addHateoas(movieVO);

            return ResponseEntity.status(HttpStatus.CREATED).body(movieVO);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieVO> getById(@PathVariable("id") Long id) {
        try {
            MovieVO movieVO = response.convertForMovieVO(movieService.getById(id));
            return ResponseEntity.ok(movieVO);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    private void addHateoas(MovieVO movieVO) {
        movieVO.add(linkTo(methodOn(MovieController.class).getById(movieVO.getId()))
                .withSelfRel());
    }


}
