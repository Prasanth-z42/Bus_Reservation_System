package com.busify.bus.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bus {
    private String busNumber;
    private String busName;
    private String totalSeats;
    private String availableSeats;
    private String source;
    private String destination;

    private String isAvailable;
    private Ticket[] seats;
    private List<Ticket> bookedTickets;
    private Map<Integer, Ticket> passengersTickets = new HashMap<>();

    public Bus(String busNumber, String busName, String totalSeats, String source, String destination, String isAvailable) {
        this.busNumber = busNumber;
        this.busName = busName;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.source = source;
        this.destination = destination;
        this.isAvailable = isAvailable;
        this.seats = new Ticket[Integer.parseInt(totalSeats)];
        this.bookedTickets = new ArrayList<>();
    }
    public Bus() {
        this.bookedTickets = new ArrayList<>();
    }

    public Map<Integer, Ticket> getPassengersTickets() {
        return passengersTickets;
    }

    public void setPassengersTickets(Map<Integer, Ticket> passengersTickets) {
        this.passengersTickets = passengersTickets;
    }

    public void setBookedTickets(List<Ticket> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }


    public String isAvailable() {
        return isAvailable;
    }

    public void setAvailable(String available) {
        isAvailable = available;
    }


    public void addTicket(Ticket ticket) {
        this.bookedTickets.add(ticket);
    }

    public String getBusName() { return busName; }
    public void setBusName(String busName) { this.busName = busName; }



    public List<Ticket> getBookedTickets() {
        return bookedTickets;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Ticket[] getSeats() {
        return seats;
    }

    public void setSeats(Ticket[] seats) {
        this.seats = seats;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(String totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(String availableSeats) {
        this.availableSeats = availableSeats;
    }
}
