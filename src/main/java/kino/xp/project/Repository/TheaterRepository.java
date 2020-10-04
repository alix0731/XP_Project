package kino.xp.project.Repository;

import kino.xp.project.Model.Movie;
import kino.xp.project.Model.Theaters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TheaterRepository {

    @Autowired
    JdbcTemplate template;


    public Theaters getTheater(int theater_id) {
        String sql = "SELECT * FROM theaters WHERE theater_id = ?";
        RowMapper<Theaters> rm = new BeanPropertyRowMapper<>(Theaters.class);
        return template.queryForObject(sql, rm, theater_id);


    }

    public List<Theaters> listTheaters() {
        String sql = "SELECT * FROM theaters";
        RowMapper<Theaters> rm = new BeanPropertyRowMapper<>(Theaters.class);
        return template.query(sql, rm);
    }
}

