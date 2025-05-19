package DAO;

import DAO.Constants.SqlScriptConst;
import Model.Payment;
import util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PaymentDAO implements BASEDAO<Payment>{





    public void save(Payment payment) {
        try (Connection connection = DBUtil.getconnection()) {

            PreparedStatement ps = connection.prepareStatement(SqlScriptConst.paymentSave);
            ps.setLong(1,payment.getOrder().getId() );
            ps.setString(2,payment.getPaymentMethod().name());
            ps.setBigDecimal(3,payment.getAmount());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Payment findById(Long id) {
        return null;
    }

    @Override
    public List<Payment> findAll() {
        return List.of();
    }

    @Override
    public void update(Payment payment) {

    }

    @Override
    public void delete(long id) {

    }
}