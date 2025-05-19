import Model.Customer;
import SERVICE.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PatikaStoreMain {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);



        while (true){
            System.out.println("-----------PATİKA STORE HOŞ GELDİNİZ------------");
            System.out.println("1 - Bir müşteri kaydı");
            System.out.println("2 - Giriş Yap");
            System.out.println("3 - Tüm Müşterileri Listele");
            System.out.println("4 - Id ye göre bul");
            System.out.println("0 - Çıkış");
            System.out.println("Seçim Yapınız: ");
            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    saveCustomer(scanner);
                    break;
                case "2":
                    loginCustomer(scanner);
                    break;
                case "3":
                    findAllCustomer();
                    break;
                case "4":
                    System.out.print("Aranacak Müşteri ID'sini giriniz: ");
                    findCustomerById(scanner.nextLong());
                scanner.nextLine();
                    break;
                case "0":
                    System.out.println("Çıkış yapılıyor");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Geçersiz seçim");
            }
        }


    }

    private static void loginCustomer(Scanner scanner) {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Şifre: ");
        String password = scanner.nextLine();

        CustomerService customerService =new CustomerService();
        customerService.login(email,password);
        //TODO
    }

    private static void saveCustomer(Scanner scanner) {
        System.out.print("İsim: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Şifre: ");
        String password = scanner.nextLine();

        CustomerService customerService =new CustomerService();
        customerService.save(name,email,password);

    }

    private static void findCustomerById(Long id){
        CustomerService customerService =new CustomerService();
        System.out.println(id +". ID ye göre olan müşteri");
        Optional<Customer> byId = customerService.findById(id);

        if (byId.isPresent()){
            Customer customer=byId.get();
            System.out.println("Bulunan Müşteri: "+customer);
        }else {
            System.out.println("Belirtilen ID'ye sahip müşteri bulunamadı.");
        }


    }

    private static void findAllCustomer(){
        CustomerService customerService =new CustomerService();

        System.out.println("--- Tüm Müşteriler ---");
        List<Customer> all = customerService.findAll();
        if (all.isEmpty()){
            System.out.println("Henüz kayıtlı müşteri bulunamadı.");
        }else {
            for (Customer customer :all){
                System.out.println(customer);
            }
        }
        System.out.println("-----------------------");

    }





}
