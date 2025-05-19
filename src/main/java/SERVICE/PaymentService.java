package SERVICE;

import DAO.PaymentDAO;
import Model.Enums.PaymentMethod;
import Model.Order;
import Model.Payment;

public class PaymentService {

    private final PaymentDAO paymentDAO;

    public PaymentService() {
        this.paymentDAO=new PaymentDAO();
    }

    public Payment save(Order order, PaymentMethod paymentMethod){

        Payment payment=new Payment(order,paymentMethod);
        paymentDAO.save(payment);
        return payment;
    }
}
