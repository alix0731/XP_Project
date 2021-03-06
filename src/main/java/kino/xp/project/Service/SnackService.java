package kino.xp.project.Service;

import kino.xp.project.Model.Snack;
import kino.xp.project.Repository.SnackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnackService {

    @Autowired
    SnackRepository sp;

    public List<Snack> getSnacks(){
        return sp.getSnacks();
    }

    public boolean addSnack(Snack snack) {
        return sp.addSnack(snack);
    }

    public boolean deleteSnack(int id){
        return sp.deleteSnack(id);
    }

    public boolean editSnack(Snack snack){
        return sp.editSnack(snack);
    }

    public List<Snack> getAll(){
        return sp.getAllSnacks();
    }

    public Snack getById(int id){
        return sp.getById(id);
    }

}
