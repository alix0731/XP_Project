package kino.xp.project.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author Jacqques, Daniel, Emil Andersen
 * @Parameter input fra HTML siden "CreateMovie"
 * @Output Movie objekt
 **/

@Entity
public class Movie {
    @Id
    private int id;
    private String title;
    private int duration;
    //private int startTime;
    private int priceRank;
    //private Date startDate;
    //private Date endDate;
    private String genre;
    private String actors;

    public Movie() {
    }

    public Movie(int id, String title, int duration, int priceRank, String genre, String actors) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        //this.startTime = startTime;
        this.priceRank = priceRank;
        this.genre = genre;
        this.actors = actors;
    }

    public Movie(String title, int duration, int priceRank, String genre, String actors) {
        this.title = title;
        this.duration = duration;
        this.priceRank = priceRank;
        this.genre = genre;
        this.actors = actors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPriceRank() {
        return priceRank;
    }

    public void setPriceRank(int priceRank) {
        this.priceRank = priceRank;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String description) {
        this.genre = description;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", priceRank=" + priceRank +
                ", genre='" + genre + '\'' +
                ", actors='" + actors + '\'' +
                '}';
    }
}
