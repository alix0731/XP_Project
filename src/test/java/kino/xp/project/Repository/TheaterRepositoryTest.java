package kino.xp.project.Repository;

        import kino.xp.project.Model.Theaters;
        import kino.xp.project.Service.TheaterService;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Repository;
        import java.util.ArrayList;
        import static org.junit.jupiter.api.Assertions.assertEquals;

@Repository
public class TheaterRepositoryTest {

    @Autowired
    TheaterService ts;

    @Test
    public void listTheaters(){

        //Arrange
        ArrayList<Theaters> list = new ArrayList<>();

        Theaters theaters1 = new Theaters(3, 14,15,15, 15);
        Theaters theaters2 = new Theaters(4, 10,15,4, 15);


        list.add(theaters1);
        list.add(theaters2);

        //Act

        int expected = theaters1.getTheater_id();
        int actual = list.get(0).getTheater_id();

        //Assert
        assertEquals(expected, actual);

    }
}

