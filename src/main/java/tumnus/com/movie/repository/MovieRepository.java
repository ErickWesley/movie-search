package tumnus.com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tumnus.com.movie.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
