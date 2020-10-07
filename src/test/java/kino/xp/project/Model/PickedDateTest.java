package kino.xp.project.Model;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PickedDateTest {
    @Test
    void canGetCorrectCurrentDate()
    {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = formatter.format(date);
        assertEquals(currentDate, PickedDate.getCurrentDate());
    }
}