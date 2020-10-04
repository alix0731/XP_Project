package kino.xp.project.Model;
import kino.xp.project.Repository.ReservationRepository;
import kino.xp.project.Service.ReservationService;

import java.util.ArrayList;


/**
 * @Author Emil Norsker 3/10/20
 */


public class SeatMatrix
{

    int theater;
    ArrayList<Reservation[]> matrix;


    public SeatMatrix(String title, String date, int theater, String playtime)
    {

        //todo add check for uneven rows

        this.theater = theater;
        ReservationRepository repo = new ReservationRepository();

        System.out.println("date is  "+date);

        ArrayList<Reservation> listOfOccupiedSeats = (ArrayList<Reservation>) repo.getListOfReservationsByMovieTitleAndPlaytimeAndDate(title, playtime, date);


        //theater 1 has 240, 8 rows
        //theater 2 has 180, 10 rows

        int totalSeats = 0;
        int rows  = 0;
        if (theater == 1) {
            totalSeats = 240;
            rows =8;
        }

        else if (theater == 2)
        {
            totalSeats = 180;
            rows =10;
        }


        //create matrix

        for (int i = 0; i < rows; i++) //this fills the matrix by making lists of reservation arrays, and appending them to the matrix object.
        {
            int count = 0;

            Reservation[] reservationArray = new Reservation[totalSeats/rows];

            for (int j = 1; j <= totalSeats/rows; j++)
            {
                int seatNumber = j+(count*totalSeats/rows);
                Reservation reservation = new Reservation();

                for (Reservation reservationFromList: listOfOccupiedSeats) // determine if the reservation exist or not, if not assign the correct seat number to the reservation.
                {

                    if (reservationFromList.getSeat_nr() == seatNumber)
                    {
                        reservation = reservationFromList;
                        reservation.setIsOccupied(true);
                    }
                    else
                    {
                        reservation.setIsOccupied(false);
                        reservation.setSeat_nr(seatNumber);
                    }
                }

                reservationArray[j-1] = reservation;
            }

            matrix.add(reservationArray);
        }
    }


    public ArrayList<Reservation[]> getMatrix()
    {
        return matrix;
    }


}
