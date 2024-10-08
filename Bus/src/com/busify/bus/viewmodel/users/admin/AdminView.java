package com.busify.bus.viewmodel.users.admin;

import com.busify.bus.viewmodel.BaseScreen;
import com.busify.bus.viewmodel.booking.TicketBooking;
import com.busify.bus.viewmodel.buslist.BusList;
import com.busify.bus.viewmodel.users.login_users.UsersView;

import java.util.Scanner;

public class AdminView extends BaseScreen {
    BusList busList;
    private Scanner scanner;
    private AdminViewModel adminViewModel;
    public AdminView() {
        this.scanner = new Scanner(System.in);
        this.adminViewModel = new AdminViewModel(this);
        busList = new BusList();
    }
    public void onCreate() {
        if (hasCheckNetworkConnection()){
            displayAdminLogin();
        }else{
            System.out.println("Check internet connection....");
        }
    }
    void displayAdminLogin() {
        System.out.println("\n----------Admin Login----------");
        System.out.print("Enter Name : ");
        String adminName = scanner.nextLine();
        System.out.print("Enter Password : ");
        String adminPassword = scanner.nextLine();

        if (adminViewModel.validateUserNameAndPassword(adminName, adminPassword)) {
            displayAdminMenu(adminName);
        } else {
            System.out.println("Invalid User Name and Password");
        }
    }

    private void displayAdminMenu(String adminName) {
        String choice = "";
        while (!choice.equals("0")) {
            System.out.println("-----------------------------------");
            System.out.println("\n--- Welcome " + adminName + " ---");
            System.out.println("1. Add a new bus");
            System.out.println("2. Remove bus");
            System.out.println("3. View all buses");
            System.out.println("4. View available buses");
            System.out.println("5. View Passengers in the Bus");
            System.out.println("6. View Users");
            System.out.println("7. View all transactions");
            System.out.println("0. Logout");
            System.out.println("-----------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    busList.addNewBus();
                    break;
                case "2":
                    busList.removeBus();
                    break;
                case "3":
                    busList.viewAllBuses();
                    break;
                case "4":
                    busList.viewAvailableBuses();
                    break;
                case "5":
                    busList.viewPassengersInTheBus();
                    break;
                case "6":
                    new UsersView().viewUserLists();
                    break;
                case "7":
                    new TicketBooking().viewAllTransactions();
                    break;
                case "0":
                    System.out.println("Logging out");
                    choice = "0";
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
    }
}
