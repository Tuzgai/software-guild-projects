package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.service.VendingMachineService;
import com.sg.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author Stuart
 */
public class VendingMachineController {

    VendingMachineView view;
    VendingMachineService service;
    final int COIN_RETURN = 0;
    final int ADD_FUNDS = 1;

    public VendingMachineController(VendingMachineView view, VendingMachineService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        int choice;
        view.displayMachine(service.getAllItems());
        choice = view.displayMainMenuAndGetChoice(service.getAllItems());

        switch (choice) {
            case(COIN_RETURN):
                view.displayGoodByeMessage(service.coinReturn());
                break;
            case(ADD_FUNDS):
                service.addMoney(view.getFunds());
                break;
            default:
                
        }
    }
}
