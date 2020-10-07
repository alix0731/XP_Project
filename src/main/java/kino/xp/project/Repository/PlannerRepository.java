package kino.xp.project.Repository;

import kino.xp.project.Model.Planner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlannerRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Planner> listPlannedMovies()
    {
        String sql = "SELECT * FROM planner";
        RowMapper<Planner> rm = new BeanPropertyRowMapper<>(Planner.class);
        return jdbcTemplate.query(sql, rm);
    }
}
