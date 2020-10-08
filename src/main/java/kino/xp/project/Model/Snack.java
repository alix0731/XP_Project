package kino.xp.project.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Snack {

    @Id
    int product_id;
    String product_name;
    double product_price;
    String product_img;

    public Snack(int product_id, String product_name, double product_price, String product_img) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_img = product_img;
    }

    public Snack(String product_name, double product_price, String product_img) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_img = product_img;
    }

    public Snack() {
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String name) {
        this.product_name = name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double price) {
        this.product_price = price;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String img) {
        this.product_img = img;
    }

    public String toString(){
        return "snack: " + product_id;
    }
}
