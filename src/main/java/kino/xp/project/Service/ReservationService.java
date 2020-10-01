package kino.xp.project.Service;


import kino.xp.project.Model.Reservation;
import kino.xp.project.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationService = new ReservationRepository();

    public boolean createReservation(Reservation reservation){
        return reservationService.createReservation(reservation);
    }

    public boolean deleteReservation(int id)
    {
        return reservationService.deleteReservation(id);
    }

//    public void updateReservation(Reservation reservation)
//    {
//        reservationService.updateReservation(reservation);
//    }

    public Reservation getReservationByPhonenumber(int nr)
    {
        return reservationService.getReservationByPhonenumber(nr);
    }

}
