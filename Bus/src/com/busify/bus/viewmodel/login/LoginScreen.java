package com.busify.bus.viewmodel.login;

import com.busify.bus.viewmodel.BaseScreen;
import com.busify.bus.viewmodel.users.admin.AdminView;
import com.busify.bus.viewmodel.users.login_users.UsersView;

import java.util.Scanner;

public class LoginScreen extends BaseScreen {
    private LoginViewModel loginViewModel;
    private AdminView adminView;
    private UsersView userView;
    private Scanner scanner;
    public LoginScreen() {
        loginViewModel = new LoginViewModel(this);
        adminView = new AdminView();
        userView = new UsersView();
        scanner = new Scanner(System.in);
    }

    public void onCreate() {
        if (hasCheckNetworkConnection()) {
            displayLoginScreen();
        } else {
            System.out.println("Please check internet connection");
        }
    }

     void displayLoginScreen() {
        System.out.println("Welcome to Busify application");
        String choice="";
        while(!choice.equals("0")){
            System.out.println("----------------------------------");
            System.out.println("1.Login as Admin");
            System.out.println("2.Login as User");
            System.out.println("3.Exit");
            System.out.println("0.Logged out");
            System.out.println("----------------------------------");
            System.out.println("Enter your choice");
            choice=scanner.nextLine();
            switch (choice){
                case "1":
                    adminView.onCreate();
                    break;
                case "2":
                    userView.onCreate();
                    break;
                case "3":
                    System.exit(0);
                case "0":
                    break;
                default:
                    System.out.println("Invalid choice\n");
            }
        }
        System.out.println("\n_______________Thanks for coming_______________");
    }

    public void showErrorMessage(String invalidUserNameOrPassword) {
        System.out.println(invalidUserNameOrPassword);
    }
}
