package kino.xp.project.Service;

import kino.xp.project.Model.Theaters;
import kino.xp.project.Repository.PlannerRepository;
import kino.xp.project.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository tr;


    public Theaters getTheater(int theater_id) {
        return tr.getTheater(theater_id) ;
    }
}
