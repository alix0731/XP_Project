package kino.xp.project.Repository;

import kino.xp.project.Model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public boolean createReservation(Reservation reservation){
        String sql = "Insert INTO reservation(firstName, lastName, phonenumber, email, movie_title, movie_playtime, movie_date, reservation_date) Values(?,?,?,?,?,?,?,?)";
        return (jdbcTemplate.update(sql, reservation.getFirstName(), reservation.getLastName(),
                reservation.getPhoneNumber(), reservation.getEmail(), reservation.getMovie_title(),
                reservation.getMovie_playtime(), reservation.getMovie_date(), reservation.getReservation_date()) > 0);
    }


}
