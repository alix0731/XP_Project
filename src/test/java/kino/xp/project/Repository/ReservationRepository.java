package kino.xp.project.Repository;


import kino.xp.project.Model.Reservation;
import kino.xp.project.Service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

@SpringBootTest
public class ReservationRepository {

    @Autowired
    ReservationService rs;

    @Test
    public void createReservation(){

        //Arrange
        ArrayList<Reservation> list = new ArrayList<>();

        Reservation reservation1 = new Reservation(1, "Ali", "Raza", 23323232, "ali@hotmail.dk", "Tenet", "15:00", "01/10-20", "28/09-20", 1, 23);
        Reservation reservation2 = new Reservation(1, "Ali", "Raza", 23323232, "ali@hotmail.dk", "Tenet", "15:00", "01/10-20", "28/09-20", 2, 33);

        list.add(reservation1);
        list.add(reservation2);

        //Act

        int expected = reservation1.getReservation_id();
        int actual = list.get(0).getReservation_id();

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    public void canDeleteReservation()
    {
        Reservation r = new Reservation(0, "Hans", "Jensen", 12121212,
                                        "hansJ@mail.dk", "Tenet", "19:30", "2020-11-30",
                                        "2020-10-15", 2, 24);
        rs.createReservation(r);
        assertTrue(rs.deleteReservation(rs.getReservationByPhonenumber(12121212).getReservation_id()));
    }
}


