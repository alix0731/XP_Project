package kino.xp.project.Repository;

import kino.xp.project.Model.Snack;
import kino.xp.project.Service.SnackService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SnackRepTest {

    @Autowired
    SnackService snackService;

    @Test
    public void hasSnacks(){
        //idea is to run the add snack once.
        //run this test, if it gets data back fantastic!

        List<Snack> snackList = snackService.getSnacks(); //should be a list of snacks.

        assertTrue(snackList.size() > 0);
    }



    @Test
    public void edit(){


        ArrayList<Snack> list = new ArrayList<>();
        list.add(new Snack(1, "pop", 25, "www.dk"));


        list.get(0).setProduct_name("korn");

        //Act
        String expected = "korn";
        String actual = list.get(0).getProduct_name();

        //Assert
        assertEquals(expected, actual);

    }
}
