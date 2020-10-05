package kino.xp.project.Service;

import kino.xp.project.Model.Planner;
import kino.xp.project.Repository.PlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Daniel, Emil Andersen
 * @Parameter service lag mellem controller og repository
 * @Output metoder fra repository
 **/

@Service
public class PlannerService {
    @Autowired
    PlannerRepository ps;

    public List<Planner> listPlannedMovies()
    {
        return ps.listPlannedMovies();
    }
}
