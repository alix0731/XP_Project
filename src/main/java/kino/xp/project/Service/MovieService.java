package kino.xp.project.Service;

import kino.xp.project.Model.Movie;
import kino.xp.project.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository mr;

    public boolean addMovieToDatabase(Movie movie) {
        return mr.addMovieToDatabase(movie);
    }
}
