package kino.xp.project.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author Jacqques, Daniel, Emil Andersen
 * @Parameter input fra HTML siden "CreateMovie"
 * @Output Movie objekt
 **/

@Entity
public class Movie
{
    @Id
    private int movie_id;
    private String title;
    private int duration;
    private int price_rank;
    private int price;
    private String genre;
    private String actors;
    private String poster;

    public Movie()
    {
    }

    public Movie(int movie_id, String title, int duration, int price_rank, String genre, String actors, String poster)
    {
        this.movie_id = movie_id;
        this.title = title;
        this.duration = duration;
        this.price_rank = price_rank;
        this.genre = genre;
        this.actors = actors;
        this.poster = poster;
        switch (price_rank){
            case 1 : this.price = 65;
            case 2 : this.price = 75;
            case 3 : this.price = 95;
        }
    }

//    public Movie(String title, int duration, int priceRank, String genre, String actors, String poster)
//    {
//        this.title = title;
//        this.duration = duration;
//        this.priceRank = priceRank;
//        this.genre = genre;
//        this.actors = actors;
//        this.poster = poster;
//    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int id) {
        this.movie_id = id;
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

    public int getPrice_rank() {
        return price_rank;
    }

    public void setPrice_rank(int priceRank) {
        this.price_rank = priceRank;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {this.poster = poster;}
}
