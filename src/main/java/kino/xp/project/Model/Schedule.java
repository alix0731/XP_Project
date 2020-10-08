package kino.xp.project.Model;

public class Schedule
{
    private int id;
    private int weekNr;
    private int dayNr;
    private String type;
    private int worker1_id;
    private int worker2_id;
    private int movieO_id;
    private int ticketO_id;

    public Schedule()
    {
    }

    public Schedule(int weekNr, int dayNr, String type) {
        this.weekNr = weekNr;
        this.dayNr = dayNr;
        this.type = type;
    }

    public Schedule(int id, int weekNr, int dayNr, int worker1_id, int worker2_id, int movieO_id, int ticketO_id)
    {
        this.id = id;
        this.weekNr = weekNr;
        this.dayNr = dayNr;
        this.worker1_id = worker1_id;
        this.worker2_id = worker2_id;
        this.movieO_id = movieO_id;
        this.ticketO_id = ticketO_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeekNr() {
        return weekNr;
    }

    public void setWeekNr(int weekNr) {
        this.weekNr = weekNr;
    }

    public int getDayNr() {
        return dayNr;
    }

    public void setDayNr(int dayNr) {
        this.dayNr = dayNr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWorker1_id() {
        return worker1_id;
    }

    public void setWorker1_id(int worker1_id) {
        this.worker1_id = worker1_id;
    }

    public int getWorker2_id() {
        return worker2_id;
    }

    public void setWorker2_id(int worker2_id) {
        this.worker2_id = worker2_id;
    }

    public int getMovieO_id() {
        return movieO_id;
    }

    public void setMovieO_id(int movieO_id) {
        this.movieO_id = movieO_id;
    }

    public int getTicketO_id() {
        return ticketO_id;
    }

    public void setTicketO_id(int ticketO_id) {
        this.ticketO_id = ticketO_id;
    }
}
