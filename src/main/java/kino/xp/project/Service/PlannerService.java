package kino.xp.project.Service;

import kino.xp.project.Model.Movie;
import kino.xp.project.Model.Planner;
import kino.xp.project.Repository.MovieRepository;
import kino.xp.project.Repository.PlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlannerService {

        @Autowired
        PlannerRepository pr;

        public List<Planner> listPlanner(int movie_id) {
            return pr.listPlanner(movie_id) ;
        }

}

