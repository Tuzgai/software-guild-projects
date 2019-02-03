package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.service.InsufficientFundsException;
import com.sg.vendingmachine.service.ItemNotFoundException;
import com.sg.vendingmachine.service.VendingMachineService;
import com.sg.vendingmachine.service.ZeroInventoryException;
import com.sg.vendingmachine.ui.VendingMachineView;

/**
 *
 * @author Stuart
 */
public class VendingMachineController {

    VendingMachineView view;
    VendingMachineService service;
    final int COIN_RETURN = 0;
    final int ADD_FUNDS = 400;

    public VendingMachineController(VendingMachineView view, VendingMachineService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        int choice;
        boolean notDone = true;
        
        while (notDone) {
            choice = view.displayMainMenuAndGetChoice(service.getAllItems(), service.getBalance());

            switch (choice) {
                case (COIN_RETURN):
                    view.displayGoodByeMessage(service.coinReturn());
                    notDone = false;
                    break;
                case (ADD_FUNDS):
                    service.addMoney(view.getDeposit());
                    break;
                default:
                    try {
                        service.vendItem(service.getAllItems().get(choice).getName());
                    } catch (ItemNotFoundException
                            | ZeroInventoryException
                            | InsufficientFundsException e) {
                        view.displayError(e);
                        break;
                    }
            }
        }
    }
}
