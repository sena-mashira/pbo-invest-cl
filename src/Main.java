import data.SahamData;
import service.SahamService;
import service.UserService;
import model.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.addUser(new Admin("admin", "admin123"));
        userService.addUser(new Customer("customer", "customer123"));

        userService.start();
    }
}