package kino.xp.project.Repository;

import kino.xp.project.Model.Reservation;
import kino.xp.project.Service.ReservationService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReservationRepositoryTest {

    @Autowired
    ReservationService rs;

    @Test
    @Order(1)
    public void canCreateReservation(){
        //Arrange
        ArrayList<Reservation> list = new ArrayList<>();

        Reservation reservation1 = new Reservation(1, "Ali", "Raza", 23323232, "ali@hotmail.dk", "Tenet", "15:00", "01/10-20", "28/09-20", 1, 23,true);
        Reservation reservation2 = new Reservation(1, "Ali", "Raza", 23323232, "ali@hotmail.dk", "Tenet", "15:00", "01/10-20", "28/09-20", 2, 33, false);

        list.add(reservation1);
        list.add(reservation2);

        //Act
        int expected = reservation1.getReservation_id();
        int actual = list.get(0).getReservation_id();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @Order(2)
    public void canAddReservationToDatabase()
    {
        Reservation r = new Reservation(0, "Hans", "Jensen", 15151515,
                "hansJ@mail.dk", "Tenet", "19:30", "2020-11-30",
                "2020-10-15", 2, 24, true);
        assertTrue(rs.createReservation(r));
    }

    @Test
    @Order(3)
    void canReadReservationByPhonenumber()
    {
        Reservation r = rs.getReservationByPhonenumber(98989898);
        assertNotNull(r);
    }

    @Test
    @Order(4)
    void canDeleteReservationFromDatabase()
    {
        Reservation newR = rs.getReservationByPhonenumber(98989898);
        assertTrue(rs.deleteReservation(newR.getReservation_id()));
    }


}