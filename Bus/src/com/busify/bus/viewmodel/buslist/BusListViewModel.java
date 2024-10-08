package com.busify.bus.viewmodel.buslist;


import com.busify.bus.datalayer.BusifyRepository;
import com.busify.bus.dto.Bus;
import com.busify.bus.dto.Ticket;

import java.util.List;
import java.util.Scanner;

public class BusListViewModel {
    Scanner scanner = new Scanner(System.in);
    private BusList busList;

    public BusListViewModel(BusList busList) {
        this.busList = busList;
    }

     void addNewBus(Bus bus) {
        BusifyRepository.getInstance().getBusLists().add(bus);
        BusifyRepository.getInstance().getBuses().put(bus.getBusNumber(), bus);
        System.out.println("Bus Number "+ bus.getBusNumber()+" " + bus.getSource() + " to " + bus.getDestination() + " Bus added Successfully");
    }


     void removeBus(Bus bus) {
        BusifyRepository.getInstance().getBusLists().remove(bus);
        BusifyRepository.getInstance().getBuses().remove(bus.getBusNumber());
        System.out.println("Removed Successfully");
    }



     List<Bus> viewAllBuses() {
        return BusifyRepository.getInstance().getBusLists();
    }



     List<Ticket> viewPassengers(String busNo) {
        Bus bus = BusifyRepository.getInstance().getBuses().get(busNo);
        return bus.getBookedTickets();
    }

     List<Ticket> viewAllTransactions() {
        return BusifyRepository.getInstance().getTransaction();
    }
}
