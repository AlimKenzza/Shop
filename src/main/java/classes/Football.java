package classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Football implements Product{
    final String JDBC_DRIVER = "org.postgresql.Driver";
    final String DATABASE_URL = "jdbc:postgresql://localhost:5432/sportshop";
    final String DATABASE_USER = "postgres";
    final String DATABASE_PASSWORD = "alimzhan125";
    final String GET_ALL_FOOTBALL_RECORDS = "SELECT * FROM football";
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    private int id;
    private String item_name;
    private int price;
    ArrayList<Football> list = new ArrayList<>();

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
private void dbConnect() {
    try {
        Class.forName(JDBC_DRIVER);

        connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

    private void dbClose() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
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
    public ArrayList<Football> getAllFootballs() {
        try{
             connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            statement = connection.createStatement();

            resultSet = statement.executeQuery(GET_ALL_FOOTBALL_RECORDS);
            while(resultSet.next()){
                int id = resultSet.getInt("product_id");
                String item_name = resultSet.getString("product_name");
                int price = resultSet.getInt("price");
                Football football = new Football();
                football.setId(id);
                football.setItem_name(item_name);
                football.setPrice(price);
                list.add(football);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();

            }
return list;
    }
    public Football fetchFootball(String id) throws SQLException {
        dbConnect();
        String sql = "select * from football where product_id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstmt.executeQuery();
        Football football = new Football();
        while(rst.next()){

            football.setId(rst.getInt("product_id"));
            football.setItem_name(rst.getString("product_name"));
            football.setPrice(rst.getInt("price"));

        }
        dbClose();
        return football;
    }
}
