package kino.xp.project.Repository;

import kino.xp.project.DBConnection;
import kino.xp.project.Model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @Author Jacqques, Daniel, Emil Andersen
 * @Parameter kaldes fra MovieRepository som sender Movie-relateret requests
 * @Output kontakt til database fx gem/list
 **/

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate template;

    public boolean addMovieToDatabase(Movie m) {
        String sql = "INSERT INTO movie (title, duration, price_rank, actors, genre, poster) VALUES (?, ?, ?, ?, ?, ?)";
        return (template.update(sql, m.getTitle(), m.getDuration(), m.getPriceRank(), m.getActors(), m.getGenre(), m.getPoster()) > 0);
    }

    public List<Movie> listMovies() {
        String sql = "SELECT * FROM movie";
        RowMapper<Movie> rm = new BeanPropertyRowMapper<>(Movie.class);
        System.out.println(template.query(sql, rm));
        return template.query(sql, rm);
    }
}
