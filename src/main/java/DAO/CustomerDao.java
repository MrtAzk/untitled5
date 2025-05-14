package DAO;

import Model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    String url = "jdbc:postgresql://localhost:5432/patikaStore";

    private final String savescript= """
            INSERT INTO customer(name,email,password) VALUES(?,?,?)
            """;
    String findById =  """
                SELECT * FROM customer
                WHERE id = ?
                """;

    String findAll = """
            SELECT * FROM customer
            """;

    public  void  save(Customer customer){



        try (Connection connection = DriverManager.getConnection(url, "postgres", "postgres")) {

            PreparedStatement ps =connection.prepareStatement(savescript);
            ps.setString(1,customer.getName());
            ps.setString(2,customer.getEmail());
            ps.setString(3,customer.getPassword());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public  Customer findById(Long id){
        Customer customer =new Customer();

        try (Connection connection = DriverManager.getConnection(url, "postgres", "postgres")) {

            PreparedStatement ps =connection.prepareStatement(findById);
            ps.setLong(1,id);
            ResultSet resultSet=ps.executeQuery();


            while (resultSet.next()){

                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setEmail(resultSet.getString("email"));
                //customer.setCreatedDate(resultSet.getDate("createdDate"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return customer;
    }

    public List<Customer> findAll(){
        Customer customer =new Customer();
        List<Customer> customers =new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, "postgres", "postgres")) {

            Statement statement = connection.createStatement();

            ResultSet resultSet=statement.executeQuery(findAll);


            while (resultSet.next()){

                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setEmail(resultSet.getString("email"));
                //customer.setCreatedDate(resultSet.getDate("createdDate"));
                customers.add(customer);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;

    }
}
