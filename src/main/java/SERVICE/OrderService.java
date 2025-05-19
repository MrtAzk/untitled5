package SERVICE;

import DAO.OrderDAO;
import Model.Customer;
import Model.Order;
import Model.Product;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class OrderService {

    private final OrderDAO orderDAO;

    public OrderService() {
        this.orderDAO = new OrderDAO();
    }

    public Order save(Customer customer, List<Product> products) throws SQLException {
        BigDecimal totalAmount = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Order order = new Order();
        order.setProducts(products);
        order.setCustomer(customer);
        order.setTotalAmount(totalAmount);
        orderDAO.save(order);
        return order;
    }
}
