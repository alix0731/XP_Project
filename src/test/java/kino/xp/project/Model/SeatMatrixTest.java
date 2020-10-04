package kino.xp.project.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeatMatrixTest {


    @Test
    public void createObj(){

        //Arrange
        Reservation reservation = new Reservation(1, "Ali", "Raza", 23323232, "ali@hotmail.dk", "Tenet", "15:00", "01/10-20", "28/09-20", 2, 22,true);
        //Act
        String expectedMovieTitle = "Tenet";
        String actual = reservation.getMovie_title();
        //Assert
        assertEquals(expectedMovieTitle, actual);

    }

}
