package com.busify.bus.viewmodel.users.admin;
import com.busify.bus.datalayer.BusifyRepository;

public class AdminViewModel {
    private AdminView adminView;
    public AdminViewModel(AdminView adminView) {
        this.adminView = adminView;
    }

    boolean validateUserNameAndPassword(String name, String password) {
        return BusifyRepository.getInstance().validateAdminUserNameAndPassword(name, password);
    }

}
