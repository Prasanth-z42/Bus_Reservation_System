package com.busify.bus.viewmodel.buslist;
import java.util.*;

import com.busify.bus.datalayer.BusifyRepository;
import com.busify.bus.dto.Bus;
import com.busify.bus.dto.Ticket;
import com.busify.bus.viewmodel.BaseScreen;

public class BusList extends BaseScreen {
    Scanner scanner = new Scanner(System.in);
    private BusListViewModel busListViewModel;
    public BusList() {
        busListViewModel = new BusListViewModel(this);
    }

    public void addNewBus() {
        System.out.println("------------Add New Bus--------------");
        String busNo = "";
        String busName = "";
        String totalSeats = "";
        System.out.println("Enter Bus Number");
        busNo = scanner.nextLine();

        System.out.println("Enter Bus Name");
        busName = scanner.nextLine();

        while (true) {
            System.out.println("Enter total number of seats in the bus (max - 20)");
            totalSeats = scanner.nextLine();
            if (Integer.parseInt(totalSeats) < 0 || Integer.parseInt(totalSeats) > 20)
                System.out.println("Invalid Total Number of Seats");
            else break;
        }

        System.out.println("Enter Source");
        String source = scanner.nextLine();

        System.out.println("Enter Destination");
        String destination = scanner.nextLine();

        System.out.println("is Available (Yes/No)");
        String isAvailable = scanner.nextLine();

        Bus bus = new Bus(busNo, busName, totalSeats, source, destination, isAvailable);
        busListViewModel.addNewBus(bus);
    }
    public void removeBus() {
        System.out.println("Enter Bus Number");
        String busNo = scanner.nextLine();

        if (BusifyRepository.getInstance().getBuses().containsKey(busNo)) {
            Bus bus = BusifyRepository.getInstance().getBuses().get(busNo);
            busListViewModel.removeBus(bus);
            displayBusDetails(bus);
        } else {
            System.out.println("Bus is not available");
        }

    }

    public void viewAllBuses() {
        List<Bus> busLists = busListViewModel.viewAllBuses();
        if (busLists.size() == 0) {
            System.out.println("Buses are currently not available");
            return;
        }
        for (Bus bus : busLists) {
            displayBusDetails(bus);
        }
    }

    private void displayBusDetails(Bus bus) {
        System.out.println("---------------------------------------");
        System.out.println("Bus Number  : "+bus.getBusNumber());
        System.out.println("Bus Name    : "+bus.getBusName());
        System.out.println("Source      : "+bus.getSource());
        System.out.println("Destination : "+bus.getDestination());
        System.out.println("Available Seats : "+bus.getAvailableSeats());
        System.out.println("Available   : " + bus.getIsAvailable());
        System.out.println("---------------------------------------");
    }
    public void viewAvailableBuses() {
        List<Bus> busLists = busListViewModel.viewAllBuses();
        if (busLists.size() == 0) {
            System.out.println("Buses are currently not available");
            return;
        }
        boolean flag = false;
        for (Bus bus : busLists) {
            String isAvailable = bus.isAvailable().toLowerCase();
            if (isAvailable.equals("yes")) {
                displayBusDetails(bus);
                flag = true;
            }
        }
        if (!flag) System.out.println("Unavailable Available Buses...!");
    }

    public void viewPassengersInTheBus() {
        System.out.println("Enter Bus Number...");
        String busNo = scanner.nextLine();

        if (!BusifyRepository.getInstance().getBuses().containsKey(busNo))
            System.out.println("Invalid Bus Number...!");
        else {
            List<Ticket> passengers = busListViewModel.viewPassengers(busNo);
            if (passengers.size() > 0) {
                for (Ticket ticket : passengers) {
                    displayTicketDetails(ticket);
                }
            } else {
                System.out.println("Passenger's are not available in the bus...!");
            }
        }
    }
    public void displayTicketDetails(Ticket ticket) {
        System.out.println("--------------------------------------------");
        System.out.println("Passenger Id : " + ticket.getPassengerId());
        System.out.println("Passenger Name : " + ticket.getPassenger().getPassengerName());
        System.out.println("Passenger Age : "+ticket.getPassenger().getPassengerAge());
        System.out.println("Phone Number : "+ticket.getPassenger().getPhoneNumber());
        System.out.println("Bus Number : " + ticket.getBusNo());
        System.out.println("Seat Number : "+(ticket.getSeatNumber()+1));
        System.out.println("Source     : " + ticket.getSource());
        System.out.println("Destination : " + ticket.getDestination());
        System.out.println("Date        : " +ticket.getDate());
        System.out.println("--------------------------------------------");
    }


}
