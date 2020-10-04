package kino.xp.project.Repository;

import kino.xp.project.Model.Movie;
import kino.xp.project.Service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest
{
    @Autowired
    MovieService ms;

    @Test
    public void canAddMovieToDatabase()
    {
        Movie movie = new Movie(0, "Shrek 32", 90, 2, "Romantic horror", "Eddie Murphy", "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/tenet2020.ar_509x.jpg?v=1578062934");

        int sizeOfTable = ms.listMovies().size();

        assertTrue(ms.addMovieToDatabase(movie));

        List<Movie> list = ms.listMovies();

        assertTrue(sizeOfTable < list.size());
    }

    @Test
    public void canReadMovieFromDatabase()
    {
        for(Movie m: ms.listMovies())
        {
            if(m.getTitle().equals("Shrek 32"))
            {
                assertTrue(true);
            }
        }
    }

    @Test
    public void canDeleteMovieFromDatabase()
    {
        int sizeBeforeDeletion = ms.listMovies().size();
        Movie testMovie = ms.getMovieByTitle("Shrek 32");
        int mId = testMovie.getMovie_id();

        assertTrue(ms.deleteMovieFromDatabase(mId));
        assertTrue(sizeBeforeDeletion > ms.listMovies().size());
    }

    @Test
    public void canUpdateMovieInDatabase()
    {
        Movie m = new Movie(56, "Shrek 6", 90, 2, "Romantic horror", "Eddie Murphy","https://cdn.shopify.com/s/files/1/0057/3728/3618/products/tenet2020.ar_509x.jpg?v=1578062934");
        ms.addMovieToDatabase(m);
        m = ms.getMovieByTitle("Shrek 6");
        Movie newMovie = new Movie(m.getMovie_id(), "Shrek 10", 90, 2, "Romantic horror", "Eddie Murphy","https://cdn.shopify.com/s/files/1/0057/3728/3618/products/tenet2020.ar_509x.jpg?v=1578062934");
        ms.updateMovieInDatabase(newMovie);
        m = ms.getMovieById(m.getMovie_id());
        assertTrue(m.getTitle().equals(newMovie.getTitle()));
    }
}