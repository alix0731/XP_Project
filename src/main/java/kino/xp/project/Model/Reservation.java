/**
 * @Edit Emil Norsker 3/10/20 : added occupied flag,
 */




package kino.xp.project.Model;
import java.util.ArrayList;
import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {

    @Id
    private int reservation_id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;
    private String movie_title;
    private String movie_playtime;
    private String movie_date;
    private String reservation_date;
    private int theater_id;
    private int seat_nr;
    private boolean paid;
    private boolean isOccupied;

    public Reservation() {
    }

    public Reservation(int reservation_id, String firstName, String lastName, int phoneNumber, String email, String movie_title, String movie_playtime, String movie_date, String reservation_date, int theater_id, int seat_nr, boolean paid) {
        this.reservation_id = reservation_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.movie_title = movie_title;
        this.movie_playtime = movie_playtime;
        this.movie_date = movie_date;
        this.reservation_date = reservation_date;
        this.theater_id = theater_id;
        this.seat_nr = seat_nr;
        this.paid = paid;
        this.isOccupied = false;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_playtime() {
        return movie_playtime;
    }

    public void setMovie_playtime(String movie_playtime) {
        this.movie_playtime = movie_playtime;
    }

    public String getMovie_date() {
        return movie_date;
    }

    public void setMovie_date(String movie_date) {
        this.movie_date = movie_date;
    }

    public String getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(String reservation_date) {
        this.reservation_date = reservation_date;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public int getSeat_nr() {
        return seat_nr;
    }

    public void setSeat_nr(int seat_nr) {
        this.seat_nr = seat_nr;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void fillmatrix()
    {

    }


    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_id=" + reservation_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", movie_title='" + movie_title + '\'' +
                ", movie_playtime='" + movie_playtime + '\'' +
                ", movie_date='" + movie_date + '\'' +
                ", reservation_date='" + reservation_date + '\'' +
                ", theater_id=" + theater_id +
                ", seat_nr=" + seat_nr +
                ", paid=" + paid +
                '}';
    }

    public boolean isOccupied()
    {
       return isOccupied;
    }

    public void setIsOccupied(boolean value)
    {
        isOccupied = value;
    }

}


