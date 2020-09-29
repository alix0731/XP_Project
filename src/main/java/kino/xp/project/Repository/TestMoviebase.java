package kino.xp.project.Repository;

import kino.xp.project.Service.MovieService;

public class TestMoviebase {

    public static void main(String[] args) {
        MovieService movieService = new MovieService();

        System.out.println(       movieService.listMovies().size()
);
    }
}
