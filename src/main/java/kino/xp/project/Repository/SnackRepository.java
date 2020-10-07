package kino.xp.project.Repository;


import kino.xp.project.Model.Snack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SnackRepository {

    @Autowired
    JdbcTemplate template;

    public List<Snack> getSnacks(){
        //henter en liste med snacks
        String sql = "SELECT * FROM snacks";
        RowMapper<Snack> rm = new BeanPropertyRowMapper<>(Snack.class);
        return template.query(sql,rm);
    }

    public boolean addSnack(Snack snack){
        //tilføjer en snack til databasen.
        String sql = "INSERT INTO snacks (product_name,product_price,product_img) VALUES (?,?,?)";
        return (template.update(sql,snack.getName(),snack.getPrice(),snack.getImg())> 0);
    }


    public boolean deleteSnack(int snackId)
    {
        String sql = "DELETE FROM snacks WHERE snackId = ?";
        return template.update(sql, snackId) > 0;
    }




}
