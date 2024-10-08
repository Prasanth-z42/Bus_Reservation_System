package com.busify.bus.viewmodel.booking;

import com.busify.bus.datalayer.BusifyRepository;
import com.busify.bus.dto.Bus;
import com.busify.bus.dto.Ticket;
import com.busify.bus.viewmodel.buslist.BusList;

import java.util.List;
import java.util.Scanner;

public class TicketBookingViewModel {
    Scanner scanner = new Scanner(System.in);
    private TicketBooking ticketBooking;
    private BusList busList;
    public TicketBookingViewModel(TicketBooking ticketBooking) {
        this.ticketBooking = ticketBooking;
        busList = new BusList();
    }

     void bookTicket(Bus bus, Ticket ticket) {
        bus.addTicket(ticket);
        bus.getSeats()[ticket.getSeatNumber()] = ticket;
        bus.getPassengersTickets().put(ticket.getPassengerId(), ticket);
        BusifyRepository.getInstance().getTransaction().add(ticket);
        BusifyRepository.getInstance().getBookedTickets().put(ticket.getBusNo(), ticket);
        bus.setAvailableSeats((Integer.parseInt(bus.getAvailableSeats()) - 1) + "");
        System.out.println("Ticket booked Successfully");
        if (bus.getAvailableSeats().equals("0"))
            bus.setIsAvailable("no");
        else {
            bus.setIsAvailable("yes");
        }
    }

     void cancelTicket(int passengerId, Bus bus) {
        if (bus.getPassengersTickets().containsKey(passengerId)) {
            Ticket ticket = bus.getPassengersTickets().get(passengerId);
            bus.getPassengersTickets().remove(passengerId);
            bus.getSeats()[ticket.getSeatNumber()] = null;
            bus.getBookedTickets().remove(ticket);
            bus.setAvailableSeats(bus.getAvailableSeats()+1);
        }

        bus.setIsAvailable("yes");
    }

    List<Ticket> viewAllTransactions() {
        return BusifyRepository.getInstance().getTransaction();
    }

     boolean isContains(String number) {
        for (char ch : number.toCharArray()) {
            if (Character.isLetter(ch)) return true;
        }
        return false;
    }
}
