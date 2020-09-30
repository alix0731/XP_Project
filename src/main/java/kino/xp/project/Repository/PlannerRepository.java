package kino.xp.project.Repository;

import kino.xp.project.Model.Movie;
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
    JdbcTemplate template;


    public List<Planner> listPlanner(int movie_id) {
        String sql = "SELECT * FROM planner WHERE movie_id = ?";
        RowMapper<Planner> rm = new BeanPropertyRowMapper<>(Planner.class);
        System.out.println(template.query(sql, rm));
        return template.query(sql,rm,movie_id);
    }



}