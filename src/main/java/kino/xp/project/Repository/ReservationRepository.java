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
        String sql = "SELECT * FROM reservation WHERE phoneNumber = ? limit 1";
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

        Integer numberOfSeats = jdbcTemplate.queryForObject(sql, Integer.class, theaterId);
        Integer numberOfRows = jdbcTemplate.queryForObject(sql2, Integer.class, theaterId);
        int totalSeats = (numberOfSeats) * (numberOfRows); //16 * 25
        int percentageReserved = (getNumberOfReservations(title, playtime, date)*100)/totalSeats; //5 / (16 * 25)

        if(percentageReserved == 100) { //100% reserved
            return 0;
        } else if (percentageReserved >= 75) { //75% reserved
            return 1;
        } else { //less than 75% reserved
            return 2;
        }




    }

    public static int absoluteValue(int i) {
        return (i < 0) ? -i : i;
    }
}
