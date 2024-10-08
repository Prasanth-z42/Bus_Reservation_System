package com.busify.bus.viewmodel.booking;

import com.busify.bus.datalayer.BusifyRepository;
import com.busify.bus.dto.Bus;
import com.busify.bus.dto.Passenger;
import com.busify.bus.dto.Ticket;
import com.busify.bus.validate.Validator;
import com.busify.bus.viewmodel.BaseScreen;
import com.busify.bus.viewmodel.buslist.BusList;

import java.util.List;
import java.util.Scanner;

public class TicketBooking extends BaseScreen {
    private Validator validator;
    private BusList busList = new BusList();
    Scanner scanner = new Scanner(System.in);
    private TicketBookingViewModel ticketBookingViewModel;
    public TicketBooking() {
        ticketBookingViewModel = new TicketBookingViewModel(this);
        validator = new Validator();
    }

    public void bookTicket() {
        busList.viewAvailableBuses();

        String passengerName = "";
        String passengerAge = "";
        String phoneNumber = "";
        String source = "";
        String destination = "";
        String date = "";
        int seatNumber = -1;
        System.out.println("Enter Bus Number");
        String busNo = scanner.nextLine();
        boolean flag = false;
        if (!BusifyRepository.getInstance().getBuses().containsKey(busNo)) {
            System.out.println("unavailable bus");
            return;
        }
        Bus bus = BusifyRepository.getInstance().getBuses().get(busNo);
        if (bus.getAvailableSeats().equals("0"))
            System.out.println("Bus is full...  Try another Bus...!");

        while (true) {
            System.out.println("Enter Date format(dd-mm-yyyy)");
            date = scanner.nextLine();
            String[] dateArr = date.split("-");
            if (dateArr.length != 3 || !checkDate(dateArr))
                System.out.println("Please Enter correct format of date");
            else break;
        }

        while (true) {
            System.out.println("Enter Seat Number (1 - "+bus.getTotalSeats() + ")");
            seatNumber = scanner.nextInt()-1;
            scanner.nextLine();
            if (seatNumber >= 0 && seatNumber < Integer.parseInt(bus.getTotalSeats()))
                if (bus.getSeats()[seatNumber] != null) {
                    System.out.println("Seat is already occupied...! Pick another seat");
                    checkSeats(bus.getSeats());
            }
            else break;
        }

        if (bus.isAvailable().equals("no".toLowerCase())) {
            System.out.println("Bus is full... Try another bus");
            return;
        } else {
            while (true) {
                System.out.println("Enter Passenger Name [a-zA-Z] at least more than 3 letters");
                passengerName = scanner.nextLine();
                if (!validator.validateName(passengerName))
                    System.out.println("Invalid Passenger Name... Please enter at least more than 3 characters");
                else break;
            }

            while (true) {
                System.out.println("Enter Passenger Age (1-90)");
                passengerAge = scanner.nextLine();
                if (Integer.parseInt(passengerAge) < 1 || Integer.parseInt(passengerAge) > 90)
                    System.out.println("Invalid Passenger Age...");
                else
                    break;
            }

            while (true) {
                System.out.println("Enter Passenger Phone Number");
                phoneNumber = scanner.nextLine();
                if (phoneNumber.length() != 10 || ticketBookingViewModel.isContains(phoneNumber))
                    System.out.println("Invalid Phone Number");
                else break;
            }

        }

        source = bus.getSource();
        destination = bus.getDestination();


        Ticket ticket = new Ticket(busNo, source, destination, date, new Passenger(passengerName, passengerAge, phoneNumber), seatNumber);
        displayTicketDetails(ticket);
        ticketBookingViewModel.bookTicket(bus, ticket);
    }

    private void checkSeats(Ticket[] seats) {
        int[] vis = new int[seats.length];
        for (int i = 0; i<seats.length; i++) {
            if (seats[i] == null)
                vis[i] = 0;
            else
                vis[i] = 1;
        }
        for (int i = 0; i<seats.length; i++) {
            if (i % 5 == 0)
                System.out.println();

            System.out.print(vis[i] + " ");
        }
        System.out.println();
    }

    private boolean checkDate(String[] dateArr) {
        int day = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int year = Integer.parseInt(dateArr[2]);
        System.out.println(day +" " + month + " " + year);
        return (day > 0 && day < 31) && (month < 13 && month > 0) && (year > 2023);
    }

    public void displayTicketDetails(Ticket ticket) {
        System.out.println("--------------------------------------------");
        System.out.println("Passenger Id : " + ticket.getPassengerId());
        System.out.println("Passenger Name : " + ticket.getPassenger().getPassengerName());
        System.out.println("Passenger Age : "+ticket.getPassenger().getPassengerAge());
        System.out.println("Phone Number : "+ticket.getPassenger().getPhoneNumber());
        System.out.println("Bus Number : " + ticket.getBusNo());
        System.out.println("Seat Number : " + (ticket.getSeatNumber()+1));
        System.out.println("Source     : " + ticket.getSource());
        System.out.println("Destination : " + ticket.getDestination());
        System.out.println("Date        : " +ticket.getDate());
        System.out.println("Ticket Price : "+ticket.getPrice());
        System.out.println("--------------------------------------------");
    }

    public void cancelTicket() {
        System.out.println("Enter Bus Number");
        String busNo = scanner.nextLine();
        if (!BusifyRepository.getInstance().getBuses().containsKey(busNo))
            System.out.println("Unavailable Bus");
        else {
            Bus bus = BusifyRepository.getInstance().getBuses().get(busNo);
            System.out.println("Enter Passenger id");
            int passengerId = scanner.nextInt();
            scanner.nextLine();
            if (bus.getPassengersTickets().containsKey(passengerId)) {
                ticketBookingViewModel.cancelTicket(passengerId, bus);
                System.out.println("Cancelled Successfully");
            }
            else {
                System.out.println("Invalid Passenger");
            }
        }
    }
    public void viewAllTransactions() {
        List<Ticket> transactionList = ticketBookingViewModel.viewAllTransactions();
        if (transactionList.size() == 0) System.out.println("No Transactions...");
        for (Ticket ticket : transactionList) {
            displayTicketDetails(ticket);
        }
        System.out.println();
    }
}
