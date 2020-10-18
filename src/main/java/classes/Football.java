package classes;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Football implements Product{
    private int id;
    private String item_name;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



//    public Football(int id, String item_name, int price) {
//        this.id = id;
//        this.item_name = item_name;
//        this.price = price;
//    }

    @Override
    public String toString() {
        return "Football{" +
                "id=" + id +
                ", item_name='" + item_name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public void getTotalPrice() {
    }
}
