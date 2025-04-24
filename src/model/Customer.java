package model;

public class Customer extends User {

    public Customer(String username, String password) {
        super(username, password);
    }

    @Override
    public void showMenu() {
        System.out.println("Customer Menu");
    }
}
