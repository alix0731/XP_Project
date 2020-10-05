package kino.xp.project.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Snack {

    @Id
    int snackId;
    String name;
    double price;
    String img;

    public Snack(int snackId, String name, double price, String img) {
        this.snackId = snackId;
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public Snack(String name, double price, String img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public Snack() {
    }

    public int getSnackId() {
        return snackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
