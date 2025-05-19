package DAO;

import DAO.Constants.SqlScriptConst;
import Model.Customer;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements BASEDAO<Customer> {
    String url = "jdbc:postgresql://localhost:5432/patikaStore";


    public void save(Customer customer) {
        try (Connection connection = DBUtil.getconnection()) {
            PreparedStatement ps = connection.prepareStatement(SqlScriptConst.customerSaveScript);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPassword());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer findById(Long id) {
        Customer customer = null;

        try (Connection connection = DBUtil.getconnection()) {
            PreparedStatement ps = connection.prepareStatement(SqlScriptConst.customerFindById);
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setCreatedDate(new Timestamp(resultSet.getDate("createdDate").getTime()).toLocalDateTime());
                customer.setUpdatedDate(new Timestamp(resultSet.getDate("updatedDate").getTime()).toLocalDateTime());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = DBUtil.getconnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlScriptConst.customerFindAll);

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setCreatedDate(new Timestamp(resultSet.getDate("createdDate").getTime()).toLocalDateTime());
                customer.setUpdatedDate(new Timestamp(resultSet.getDate("updatedDate").getTime()).toLocalDateTime());
                customers.add(customer);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public void update(Customer customer) {
        // Implementation needed
    }

    @Override
    public void delete(long id) {
        // Implementation needed
    }

    public boolean exitsByEmail(String email) {
        try (Connection connection = DBUtil.getconnection()) {
            PreparedStatement statement = connection.prepareStatement(SqlScriptConst.customerExitsByEmail);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer findByEmail(String email) {
        Customer customer = null;
        try (Connection connection = DBUtil.getconnection()) {
            PreparedStatement statement = connection.prepareStatement(SqlScriptConst.customerExitsByEmail);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("password"));
                customer.setCreatedDate(new Timestamp(resultSet.getDate("createdDate").getTime()).toLocalDateTime());
                customer.setUpdatedDate(new Timestamp(resultSet.getDate("updatedDate").getTime()).toLocalDateTime());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }
}
