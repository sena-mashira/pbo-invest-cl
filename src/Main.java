import service.UserService;
import model.*;

public class Main {
    public static void main(String[] args) {
//        Create object of UserService
        UserService userService = new UserService();
//        Hardcode Account
        userService.addUser(new Admin("admin", "admin123"));
        userService.addUser(new Customer("customer", "customer123"));
//        Start the program
        userService.start();
    }
}