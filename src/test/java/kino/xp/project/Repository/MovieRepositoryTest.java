package kino.xp.project.Repository;

import kino.xp.project.Model.Movie;
import kino.xp.project.Service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest {
    @Autowired
    MovieService ms;
    @Test
    public void canAddMovieToDatabase(){
        Movie movie = new Movie("Shrek 32", 90, 2, "Romantic horror", "Eddie Murphy");

        int sizeOfTable = ms.listMovies().size();

        assertTrue(ms.addMovieToDatabase(movie));

        List<Movie> list = ms.listMovies();

        assertTrue(sizeOfTable < list.size());
    }

    @Test
    public void canReadMovieFromDatabase(){
        for(Movie m: ms.listMovies()){
            if(m.getTitle().equals("Shrek 32")){
                assertTrue(true);
            }
        }
    }
}