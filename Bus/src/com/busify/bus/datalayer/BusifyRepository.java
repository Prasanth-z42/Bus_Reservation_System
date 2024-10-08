package com.busify.bus.datalayer;
import com.busify.bus.dto.Bus;
import com.busify.bus.dto.Ticket;
import com.busify.bus.dto.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusifyRepository {
    private   List<Bus> busLists = new ArrayList<>();
    private   Map<String, Bus> buses = new HashMap<>();

    private List<User> usersList = new ArrayList<>();
    public Map<String, User> users = new HashMap<>();
    private List<Ticket> transaction = new ArrayList<>();
    private Map<String, Ticket> bookedTickets = new HashMap<>();


    static BusifyRepository busifyRepository;
    private String adminName = "prasanth";
    private String adminPassword = "duke200bs6";
    public static BusifyRepository getInstance() {
        if (busifyRepository == null)
            busifyRepository = new BusifyRepository();
        return busifyRepository;
    }


    public boolean validateAdminUserNameAndPassword(String name, String password) {
        return (name.equals(adminName) && password.equals(adminPassword));
    }

    public boolean validateUser(String phoneNumber, String password) {
        return users.containsKey(phoneNumber) && users.get(phoneNumber).getPassword().equals(password);
    }

    public List<Bus> getBusLists() {
        return busLists;
    }

    public void setBusLists(List<Bus> busLists) {
        this.busLists = busLists;
    }




    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }


    public Map<String, Bus> getBuses() {
        return buses;
    }

    public void setBuses(Map<String, Bus> buses) {
        this.buses = buses;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public List<Ticket> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Ticket> transaction) {
        this.transaction = transaction;
    }

    public Map<String, Ticket> getBookedTickets() {
        return bookedTickets;
    }


    public static BusifyRepository getBusifyRepository() {
        return busifyRepository;
    }

    public static void setBusifyRepository(BusifyRepository busifyRepository) {
        BusifyRepository.busifyRepository = busifyRepository;
    }

    public void setBookedTickets(Map<String, Ticket> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
