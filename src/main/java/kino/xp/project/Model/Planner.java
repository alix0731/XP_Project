package kino.xp.project.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Planner {
    @Id
    int planner_id;
    String startDate;
    String endDate;
    String start_time;
    int theater_id;
    int movie_id;

    public Planner() {
    }

    public Planner(int planner_id, String startDate, String endDate, String start_time, int theater_id, int movie_id) {
        this.planner_id = planner_id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.start_time = start_time;
        this.theater_id = theater_id;
        this.movie_id = movie_id;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getPlanner_id() {
        return planner_id;
    }

    public void setPlanner_id(int planner_id) {
        this.planner_id = planner_id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
}
