package kino.xp.project.Repository;

import kino.xp.project.Model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * @Author Jacqques, Daniel, Emil Andersen
 * @Parameter kaldes fra MovieRepository som sender Movie-relateret requests
 * @Output kontakt til database fx gem/list
 **/

@Repository
public class MovieRepository
{
    @Autowired
    JdbcTemplate template;

    public boolean addMovieToDatabase(Movie m)
    {
        String sql = "INSERT INTO movie (title, duration, price_rank, actors, genre, poster) VALUES (?, ?, ?, ?, ?, ?)";
        return (template.update(sql, m.getTitle(), m.getDuration(), m.getPrice_rank(), m.getActors(), m.getGenre(), m.getPoster()) > 0);
    }

    public List<Movie> listMovies()
    {
        String sql = "SELECT * FROM movie";
        RowMapper<Movie> rm = new BeanPropertyRowMapper<>(Movie.class);
        return template.query(sql, rm);
    }

    public boolean deleteMovieFromDatabase(int id)
    {
        String sql = "DELETE FROM movie WHERE movie_id = ?";
        return template.update(sql, id) > 0;
    }

    public Movie getMovieById(int id)
    {
        String sql = "SELECT * FROM movie WHERE movie_id = ?";
        RowMapper<Movie> rm = new BeanPropertyRowMapper<>(Movie.class);
        return template.queryForObject(sql, rm, id);
    }

    public Movie getMovieByTitle(String title)
    {
        String sql = "SELECT * FROM movie WHERE title = ?";
        RowMapper<Movie> rm = new BeanPropertyRowMapper<>(Movie.class);
        return template.queryForObject(sql, rm, title);
    }

    public void updateMovieInDatabase(Movie m)
    {
        String sql = "UPDATE movie SET title = ?, duration = ?, price_rank = ?, " +
                     "genre = ?, actors = ?, poster = ? WHERE movie_id = ?";
        template.update(sql, m.getTitle(), m.getDuration(), m.getPrice_rank(),
                        m.getGenre(), m.getActors(), m.getPoster(), m.getMovie_id());
    }
}
