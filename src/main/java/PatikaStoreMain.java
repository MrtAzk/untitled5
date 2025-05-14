import SERVICE.CustomerService;

import java.util.Scanner;

public class PatikaStoreMain {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);


        while (true){
            System.out.println("-----------PATİKA STORE HOŞ GELDİNİZ------------");
            System.out.println("1 - Bir müşteri kaydı");
            System.out.println("2 - Giriş Yap");
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
                case "0":
                    System.out.println("Çıkış yapılıyor");
                    break;

                default:
                    System.out.println("Geçersiz seçim");
            }
        }
    }

    private static void loginCustomer(Scanner scanner) {
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
}
