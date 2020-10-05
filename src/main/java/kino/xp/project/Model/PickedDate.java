package kino.xp.project.Model;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PickedDate {
    private String pickedDate;

    public PickedDate() {
    }

    public PickedDate(String pickedDate) {
        this.pickedDate = pickedDate;
    }

    public String getPickedDate() {
        return pickedDate;
    }

    public void setPickedDate(String pickedDate) {
        this.pickedDate = pickedDate;
    }

    public static String getCurrentDate()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        return dtf.format(now);
    }
}
