package com.busify.bus.viewmodel;

public abstract class BaseScreen {
    public  boolean hasCheckNetworkConnection(){
        return checkNetworkConnection();
    };
    public boolean checkNetworkConnection(){
        return true;
    }
}
