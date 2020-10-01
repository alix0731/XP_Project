package kino.xp.project.Repository;

import kino.xp.project.Model.Reservation;
import kino.xp.project.Service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationRepositoryTest {

    @Autowired
    ReservationService rs;

    @Test
    public void createReservation()
    {
        Reservation r = new Reservation(0, "Hans", "Jensen", 15151515,
                "hansJ@mail.dk", "Tenet", "19:30", "2020-11-30",
                "2020-10-15", 2, 24);

        assertTrue(rs.createReservation(r));
    }

    @Test
    void deleteReservation()
    {
        Reservation r = new Reservation(0, "Hans", "Jensen", 12121212,
                "hansJ@mail.dk", "Tenet", "19:30", "2020-11-30",
                "2020-10-15", 2, 24);
        rs.createReservation(r);
        Reservation newR = rs.getReservationByPhonenumber(12121212);
        assertTrue(rs.deleteReservation(newR.getReservation_id()));
    }
}