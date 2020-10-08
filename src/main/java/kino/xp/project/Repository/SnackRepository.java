package kino.xp.project.Repository;


import kino.xp.project.DBConnection;
import kino.xp.project.Model.Snack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SnackRepository {

    private Connection conn = DBConnection.getDatabaseConnection();

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
        return (template.update(sql,snack.getProduct_name(),snack.getProduct_price(),snack.getProduct_img())> 0);
    }


    public boolean deleteSnack(int snackId)
    {
        String sql = "DELETE FROM snacks WHERE product_id = ?";
        return template.update(sql, snackId) > 0;
    }


    public boolean editSnack(Snack snack){
        String sql = "update snacks set product_name = ?,product_price = ?, product_img = ? where product_id = ?";

        return (template.update(sql, snack.getProduct_name(), snack.getProduct_price(), snack.getProduct_price(),snack.getProduct_id()) > 0);

    }

    public List<Snack> getAllSnacks() {

        List<Snack> productList = new ArrayList<>();

        try {
            Statement statement = conn.createStatement();
            ResultSet rs =statement.executeQuery("SELECT * FROM snacks");

            while (rs.next()){
                Snack snack = new Snack(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
                productList.add(snack);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public Snack getById(int id){

        Snack snack = new Snack();
        try {
            PreparedStatement pre = conn.prepareStatement("SELECT * from snacks where product_id = ?");
            pre.setInt(1, id);
            ResultSet resultSet = pre.executeQuery();

            while (resultSet.next()){
                snack.setProduct_id(resultSet.getInt(1));
                snack.setProduct_name(resultSet.getString(2));
                snack.setProduct_price(resultSet.getDouble(3));
                snack.setProduct_img(resultSet.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return snack;
    }




}
