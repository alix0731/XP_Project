package kino.xp.project.Service;

import kino.xp.project.Model.Movie;
import kino.xp.project.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author Jacqques, Daniel, Emil Andersen
 * @Parameter servicelag mellem controller og repositories
 * @Output sender metode videre til MovieRepository
 **/

@Service
public class MovieService
{
    @Autowired
    MovieRepository mr;

    public boolean addMovieToDatabase(Movie movie)
    {
        return mr.addMovieToDatabase(movie);
    }

    public List<Movie> listMovies()
    {
        return mr.listMovies();
    }

    public boolean deleteMovieFromDatabase(int id)
    {
        return mr.deleteMovieFromDatabase(id);
    }

    public Movie getMovieById(int id)
    {
        return mr.getMovieById(id);
    }

    public Movie getMovieByTitle(String title)
    {
        return mr.getMovieByTitle(title);
    }

    public void updateMovieInDatabase(Movie m)
    {
        mr.updateMovieInDatabase(m);
    }
}
