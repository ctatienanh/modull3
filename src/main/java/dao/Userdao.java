package dao;

import connect.Connect;
import model.Product;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class Userdao {
    public Userdao() {
    }

    public ArrayList<Product> getAllproduct(){
        String SELECT_ALL_USERS = "select * from thongtin";
        ArrayList<Product> products = new ArrayList<>();
        try(Connection connection = Connect.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String img = resultSet.getString("img");
                products.add(new Product(id,name,price,img));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean save(Product product) {
        String sql = "insert into thongtin value (?,?,?,?)";
        try (Connection connection = Connect.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setString(4, product.getImg());
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public boolean updateUser(Product product) {
        boolean rowUpdated;
        String update = "update thongtin set name = ?,price= ?, img =? where id = ?;";
        try (Connection connection = Connect.getConnection(); PreparedStatement statement = connection.prepareStatement(update)) {
            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getPrice());
            statement.setString(4, product.getImg());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }


}
