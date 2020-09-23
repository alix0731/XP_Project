package kino.xp.project.Repository;

import kino.xp.project.Model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate template;

    public boolean addMovieToDatabase(Movie m) {
        String sql = "INSERT INTO Movie (title, duration, priceRank, actors, genre) VALUES (?, ?, ?, ?, ?)";
        return (template.update(sql, m.getTitle(), m.getDuration(), m.getPriceRank(), m.getActors(), m.getGenre()) > 0);
    }
}
