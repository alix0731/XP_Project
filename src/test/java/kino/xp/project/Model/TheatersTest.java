package kino.xp.project.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheatersTest {


    @Test
    public void createObj(){

        //Arrange
        Theaters theaters = new Theaters(1, 16,15 ,15,16);
        //Act
        int expectedTheater = 1;
        int actual = theaters.getTheater_id();
        //Assert
        assertEquals(expectedTheater, actual);

    }
}
