package com.busify.bus.viewmodel.users.login_users;

import com.busify.bus.datalayer.BusifyRepository;
import com.busify.bus.dto.User;
import com.busify.bus.validate.Validator;
import com.busify.bus.viewmodel.booking.TicketBooking;
import com.busify.bus.viewmodel.buslist.BusList;

import java.util.List;
import java.util.Scanner;

public class UsersViewModel {
    Scanner scanner = new Scanner(System.in);
    private BusList busList;
    private TicketBooking ticketBooking;
    private Validator validator;
    private UsersView userView;
    public UsersViewModel(UsersView userView) {
        this.userView = userView;
        this.validator = new Validator();
        this.busList = new BusList();
        this.ticketBooking = new TicketBooking();
    }

    boolean validateName(String name) {
        return validator.validateName(name);
    }


    void registerUser(User user) {
        BusifyRepository.getInstance().getUsersList().add(user);

        BusifyRepository.getInstance().users.put(user.getPhoneNumber(), user);
    }

    void checkUser(String phoneNumber, String password) {
        if (BusifyRepository.getInstance().validateUser(phoneNumber, password)) {
            User user = BusifyRepository.getInstance().users.get(phoneNumber);
            userView.displayUserMenu(user.getName());
        } else {
            System.out.println("Invalid user");
        }
    }

    public List<User> viewUserLists() {
        return BusifyRepository.getInstance().getUsersList();
    }

     boolean isContains(String number) {
        for (char ch : number.toCharArray()) {
            if (Character.isLetter(ch)) return true;
        }
        return false;
    }
}
