package com.busify.bus.dto;

public class Passenger {
    private String passengerName;
    private String passengerAge;
    private String phoneNumber;

    public Passenger(String passengerName, String passengerAge, String phoneNumber) {
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.phoneNumber = phoneNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(String passengerAge) {
        this.passengerAge = passengerAge;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
