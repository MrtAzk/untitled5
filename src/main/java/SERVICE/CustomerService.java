package SERVICE;

import DAO.CustomerDao;
import Model.Customer;
import util.PasswordUtil;

import java.util.List;
import java.util.Optional;

public class    CustomerService {

    private final CustomerDao customerDao;


    public CustomerService() {
        customerDao=new CustomerDao();
    }

    public void save(String name, String email, String password){

        boolean isExits = customerDao.exitsByEmail(email);

        if (isExits){
            System.out.println("Bu mail zaten kayıtlı");
            return;
        }else {
            Customer customer =new Customer(name, email, PasswordUtil.hash(password));
            customerDao.save(customer);

            System.out.println("Kayıt başarılı");
        }

    }

    public Optional<Customer>findById(Long id){
        Customer customer =customerDao.findById(id);
        return Optional.ofNullable(customer);
    }

    public List<Customer>findAll(){
        List<Customer> allcustomer=customerDao.findAll();
        return allcustomer;
    }

    public void login(String email, String password) {
        boolean isExits = customerDao.exitsByEmail(email);

        if (isExits) {
            System.out.println("Bu mail ");
            return;
        }
        String hashedPassword = PasswordUtil.hash(password);
         Customer foundCustomer =customerDao.findByEmail(email);

         if (foundCustomer !=null){
             boolean passwordEquals = foundCustomer.getPassword().equals(hashedPassword);
             if (!passwordEquals){}
             System.out.println("Girilen şifre ya da  email bilgisi yanlıştır ");
         }else {
             System.out.println("Kullanıcı sisteme giriş yaptı!");
         }
    }

}
