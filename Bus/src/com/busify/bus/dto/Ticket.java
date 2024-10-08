package com.busify.bus.dto;

import java.util.Date;

public class Ticket {
    static int idProvider = 1;
    private int passengerId;
    private String busNo;
    private String source;
    private String destination;
    private String date;

    private Passenger passenger;
    private int seatNumber;
    private double price;
    public Ticket(String busNo, String source, String destination, String date, Passenger passenger, int seatNumber) {
        this.busNo = busNo;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
        this.price = 500;
        this.passengerId = idProvider++;
    }

    public double getPrice() {
        return price;
    }

    public static int getIdProvider() {
        return idProvider;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public static void setIdProvider(int idProvider) {
        Ticket.idProvider = idProvider;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }


    public String getDate() {
        return date;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
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



}
