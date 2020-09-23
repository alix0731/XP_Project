package kino.xp.project.Repository;

import kino.xp.project.Model.Movie;
import kino.xp.project.Service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    @RunWith(SpringJUnit4ClassRunner)
    @Autowired
    MovieService ms;
    @Test
    public void canAddMovieToDatabase(){
        Movie movie = new Movie("Shrek 32", 90, 2, "Romantic horror", "Eddie Murphy");

        int sizeOfTable = ms.listMovies().size();

        List<Movie> list = ms.listMovies();

        assertTrue(ms.addMovieToDatabase(movie));

        assertTrue(sizeOfTable < ms.listMovies().size());
    }

  /*  @Test
    public void canReadMovieFromDatabase(){

        MovieRepository mr = new MovieRepository();

        for(Movie movie: mr.listMovies()){
            if(movie.getTitle().equals("Shrek 32")){
                assertTrue(true);
                return;
            }
        }
        assertTrue(false);
    }
*/
}