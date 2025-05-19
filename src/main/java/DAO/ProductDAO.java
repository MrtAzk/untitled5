package DAO;

import DAO.Constants.SqlScriptConst;
import Model.Customer;
import Model.Product;
import util.DBUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements BASEDAO<Product>{


    public List<Product> seacrhByName(String name) throws SQLException {
        List<Product> products =new ArrayList<>();
        String url = "jdbc:postgresql://localhost:5432/patikaStore";

        try (Connection connection = DBUtil.getconnection()){

            PreparedStatement ps =connection.prepareStatement(SqlScriptConst.productseacrhByName);
            ps.setString(1,"%"+name+"%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Product product =new Product();
                product.setId(resultSet.getLong("id "));
                product.setName(resultSet.getString("name "));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setStock(resultSet.getInt("stock"));
                product.setCreatedDate(LocalDateTime.parse(resultSet.getString("createddate")));
                product.setUpdatedDate(LocalDateTime.parse(resultSet.getString("updateddate")));
                products.add(product);
            }

        }


        return products;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(long id) {

    }
}
