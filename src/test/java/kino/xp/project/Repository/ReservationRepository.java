package kino.xp.project.Repository;


import kino.xp.project.Model.Reservation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;


public class ReservationRepository {

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
}
