package com.busify.bus.viewmodel.users.login_users;

import com.busify.bus.dto.User;
import com.busify.bus.viewmodel.booking.TicketBooking;
import com.busify.bus.viewmodel.buslist.BusList;

import java.util.List;
import java.util.Scanner;

public class UsersView {
    BusList busList;
    private UsersViewModel usersViewModel;
    private TicketBooking ticketBooking;
    private Scanner scanner;

    public UsersView() {
        this.usersViewModel = new UsersViewModel(this);
        scanner = new Scanner(System.in);
        busList = new BusList();
        ticketBooking = new TicketBooking();
    }

    public void onCreate() {
        if (hasCheckNetworkConnection()) {
            displayUserLoginMenu();
        } else {
            System.out.println("Check internet connection....");
        }
    }

    private boolean hasCheckNetworkConnection() {
        return true;
    }

    private void displayUserLoginMenu() {
        System.out.println("-------- Users Menu --------");
        System.out.println("1. Login User");
        System.out.println("2. Register User");
        System.out.println("---------------------------------------");

        System.out.println("Enter your choice");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                displayUserLogin();
                break;
            case "2":
                registerUser();
                break;
            case "0":
                System.out.println("Logging out");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void registerUser() {
        String userName = "";
        String age = "";
        String number = "";
        String password = "";
        while (true) {
            System.out.println("Enter Passenger Name (at least 3 characters)");
            userName = scanner.nextLine();
            if (userName.length() < 3) {
                System.out.println("Invalid Name");
                return;
            }
            break;
        }

        while (true) {
            System.out.println("Enter Passenger Age");
            age = scanner.nextLine();
            if (Integer.parseInt(age) > 1 && Integer.parseInt(age) < 99)
                break;
            else {
                System.out.println("Invalid Age");
                System.out.println("Are you re-enter your age (y/n)");
                String yes = scanner.nextLine();
                if (yes.equals("y"))
                    return;
            }
        }

        while (true) {
            System.out.println("Enter Phone Number");
            number = scanner.nextLine();
            if (number.length() != 10 || usersViewModel.isContains(number))
                System.out.println("Invalid Phone number");
            else break;
        }

        while (true) {
            System.out.println("Enter Password at least 5 characters");
            password = scanner.nextLine();
            if (password.length() < 5)
                System.out.println("Try valid password");
            else break;
        }

        User user = new User(userName, age, number, password);
        usersViewModel.registerUser(user);

    }



    private void displayUserLogin() {
        System.out.println("\n----------user Login----------");
        String phoneNumber = "";
        String password = "";

        while (true) {
            System.out.println("Enter Phone Number");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.length() != 10 && usersViewModel.isContains(phoneNumber))
                System.out.println("Invalid Phone Number");
            else break;
        }

        while (true) {
            System.out.println("Enter Password");
            password = scanner.nextLine();
            if (password.length() < 5)
                System.out.println("Please re-enter password");
            else break;
        }

        usersViewModel.checkUser(phoneNumber, password);
    }

    protected void displayUserMenu(String name) {
        String choice = "";
        while (!choice.equals("0")) {
            System.out.println("\n--- Welcome " +name+ " ---");
            System.out.println("1. View all buses");
            System.out.println("2. View available buses");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("0. Logout");
            System.out.println("-------------------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    busList.viewAllBuses();
                    break;
                case "2":
                    busList.viewAvailableBuses();
                    break;
                case "3":
                    ticketBooking.bookTicket();
                    break;
                case "4":
                    ticketBooking.cancelTicket();
                    break;
                case "0":
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }


    }

    public void viewUserLists() {
        List<User> userList = usersViewModel.viewUserLists();
        if (userList.size() > 0) {
            for (User user : userList) {
                userDetails(user);
            }
        } else {
            System.out.println("Users are currently not available");
        }
    }
    private void userDetails(User passenger) {
        System.out.println("--------------------------------------");
        System.out.println("Passenger Name : " + passenger.getName());
        System.out.println("Passenger Age  : "+passenger.getAge());
        System.out.println("Passenger PhoneNumber : " + passenger.getPhoneNumber());
        System.out.println("--------------------------------------");
    }
}
