package kino.xp.project.Service;


import kino.xp.project.Model.Reservation;
import kino.xp.project.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public boolean createReservation(Reservation reservation){
        return reservationRepository.createReservation(reservation);
    }

    public boolean deleteReservation(int id)
    {
        return reservationRepository.deleteReservation(id);
    }

//    public void updateReservation(Reservation reservation)
//    {
//        reservationService.updateReservation(reservation);
//    }

    public Reservation getReservationByPhonenumber(int nr)
    {
        return reservationRepository.getReservationByPhonenumber(nr);
    }

    public int calculateSeatsReserved(int theaterId, String title, String playtime, String date)
    {
        return reservationRepository.calculateSeatsReserved(theaterId, title, playtime, date);
    }

}
