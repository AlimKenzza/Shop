package classes;

public class Item implements Product {
    private int id;
    private int quantity;
    private int price;
    private String item_name;
    private Football football = new Football();

    public Item(Football football, int quantity) {
        this.quantity = quantity;
        this.football = football;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Football getFootball() {
        return football;
    }

    public void setFootball(Football football) {
        this.football = football;
    }

    public Item() {
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }


    @Override
    public void getTotalPrice() {
        int total = price * quantity;
        System.out.println(total);
    }
}
