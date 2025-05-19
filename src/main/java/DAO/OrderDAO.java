package DAO;

import DAO.Constants.SqlScriptConst;
import Model.Order;
import util.DBUtil;

import java.sql.*;
import java.time.ZoneId;
import java.util.List;

public class OrderDAO implements  BASEDAO<Order> {




    public void save(Order order) throws SQLException {
        try (Connection connection = DBUtil.getconnection()){

            PreparedStatement ps = connection.prepareStatement(SqlScriptConst.orderSave);
            ps.setLong(1,order.getCustomer().getId());
            ps.setTimestamp(2, Timestamp.valueOf(order.getOrderDate()));
            ps.setBigDecimal(3,order.getTotalAmount());

            ps.executeUpdate();
        }

    }

    @Override
    public Order findById(Long id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(long id) {

    }
}
