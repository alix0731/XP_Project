package kino.xp.project.Model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Theaters {

    @Id
    int theater_id;
    int seats;
    int rows;
    int deluxe_rows;
    int deluxe_seats;

    public Theaters() {
    }

    public Theaters(int seats, int rows, int deluxe_rows, int deluxe_seats) {

        this.seats = seats;
        this.rows = rows;
        this.deluxe_rows = deluxe_rows;
        this.deluxe_seats = deluxe_seats;

    }

    public Theaters(int theater_id, int seats, int rows, int deluxe_rows, int deluxe_seats) {

        this.theater_id = theater_id;
        this.seats = seats;
        this.rows = rows;
        this.deluxe_rows = deluxe_rows;
        this.deluxe_seats = deluxe_seats;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getDeluxe_rows() {
        return deluxe_rows;
    }

    public void setDeluxe_rows(int deluxe_rows) {
        this.deluxe_rows = deluxe_rows;
    }

    public int getDeluxe_seats() {
        return deluxe_seats;
    }

    public void setDeluxe_seats(int deluxe_seats) {
        this.deluxe_seats = deluxe_seats;
    }
}