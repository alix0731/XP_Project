package kino.xp.project.Repository;

import kino.xp.project.Model.Movie;
import kino.xp.project.Model.Reservation;
import kino.xp.project.Service.ReservationService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReservationRepositoryTest {

    int testphone = 98989898;

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
        Reservation r = new Reservation(0, "Hans", "Jensen", testphone,
                "hansJ@mail.dk", "Tenet", "19:30", "2020-11-30",
                "2020-10-15", 2, 24, true);
        assertTrue(rs.createReservation(r));
    }

    @Test
    @Order(3)
    void canReadReservationByPhonenumber()
    {
        List<Reservation> list = rs.getReservationByPhonenumber(testphone);
        assertNotNull(list);
    }

    @Test
    @Order(4)
    void canReadReservationById()
    {
        List<Reservation> list = rs.getReservationByPhonenumber(testphone);
        int id = list.get(0).getReservation_id();
        assertNotNull(rs.getReservationById(id));
    }

    @Test
    @Order(5)
    void canDeleteReservationFromDatabase()
    {
        List<Reservation> list = rs.getReservationByPhonenumber(testphone);
        int sizeBeforeDeletion = list.size();
        assertTrue(rs.deleteReservation(list.get(0).getReservation_id()));
        int sizeAfterDeletion = rs.getReservationByPhonenumber(testphone).size();
        assertTrue(sizeBeforeDeletion > sizeAfterDeletion);
    }

}