package kino.xp.project.Repository;

import kino.xp.project.Model.Planner;
import kino.xp.project.Model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public boolean createReservation(Reservation reservation){
        String sql = "Insert INTO reservation(firstName, lastName, phonenumber, email, movie_title, movie_playtime, movie_date, reservation_date, theater_id, seat_nr, paid) Values(?,?,?,?,?,?,?,?,?,?,?)";
        return (jdbcTemplate.update(sql, reservation.getFirstName(), reservation.getLastName(),
                reservation.getPhoneNumber(), reservation.getEmail(), reservation.getMovie_title(),
                reservation.getMovie_playtime(), reservation.getMovie_date(), reservation.getReservation_date(),
                reservation.getTheater_id(), reservation.getSeat_nr(), reservation.isPaid()) > 0);
    }

    public boolean deleteReservation(int id)
    {
        String sql = "DELETE FROM reservation WHERE reservation_id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

//    public void updateReservation(Reservation r)
//    {
//        String sql = "UPDATE reservation SET firstName = ?, lastName = ?, " +
//                     "phonenumber = ?, email = ?, movie_title = ?, movie_playtime = ?, " +
//                     "movie_date = ?, reservation_date/*, theater_id = ?, seat_nr = ?*/ " +
//                     "WHERE reservation_id = ?";
//        jdbcTemplate.update(sql, r.getFirstName(), r.getLastName(), r.getPhoneNumber(),
//                            r.getEmail(), r.getMovie_title(), r.getMovie_playtime(),
//                            r.getMovie_date(), r.getReservation_date(), /*r.getTheater_id(), r.getSeat_nr(),*/
//                            r.getReservation_id());
//    }

    public Reservation getReservationByPhonenumber(int nr)
    {
        String sql = "SELECT * FROM reservation WHERE phoneNumber = ?";
        RowMapper<Reservation> rm = new BeanPropertyRowMapper<>(Reservation.class);
        return jdbcTemplate.queryForObject(sql, rm, nr);
    }

    public List<Reservation> getListOfReservationsByMovieTitleAndPlaytimeAndDate(String title, String playtime, String date)
    {
        String sql = "SELECT * FROM reservation WHERE movie_title = ? AND movie_playtime = ? AND movie_date = ?";
        RowMapper<Reservation> rm = new BeanPropertyRowMapper<>(Reservation.class);
        return jdbcTemplate.query(sql, rm, title, playtime, date);
    }

    public int getNumberOfReservations(String title, String playtime, String date)
    {
        return getListOfReservationsByMovieTitleAndPlaytimeAndDate(title, playtime, date).size();
    }

    public int calculateSeatsReserved(int theaterId, String title, String playtime, String date)
    {
        String sql = "SELECT seats FROM theaters WHERE theater_id = ?";
        String sql2 = "SELECT rows FROM theaters WHERE theater_id = ?";

        RowMapper<Integer> rm = new BeanPropertyRowMapper<>(Integer.class);
        Integer numberOfSeats = jdbcTemplate.queryForObject(sql, rm, theaterId);
        Integer numberOfRows = jdbcTemplate.queryForObject(sql2, rm, theaterId);
        int totalSeats = numberOfSeats * numberOfRows;

        double percentageReserved = getNumberOfReservations(title, playtime, date)/totalSeats;

        //Hvis metoden returnerer 0 er der fuldt optaget, 1: 75% eller mere optaget, 2: under 75%
        if(percentageReserved == 1) {
            return 0;
        } else if(percentageReserved >=0.75) {
            return 1;
        } else {
            return 2;
        }
    }


}
