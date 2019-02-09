package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDaoException;
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

    private VendingMachineView view;
    private VendingMachineService service;
    private final int COIN_RETURN = 0;
    private final int ADD_FUNDS = 400;
    private final int ADMIN = 999;
    private final int REFILL = 1;
    private final int ADD_ITEM = 2;
    private final int REMOVE_ITEM = 3;
    private final int EDIT_ITEM = 4;
    private final int ADD_COINS = 5;
    private final int SHOW_STOCK = 6;
    private final int EXIT = 7;

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
                    try {
                        service.quit();
                    } catch (VendingMachineDaoException e) {
                        view.displayError(e);
                    }
                    view.displayGoodByeMessage(service.coinReturn());
                    notDone = false;
                    break;
                case (ADD_FUNDS):
                    service.addMoney(view.getDeposit());
                    break;
                case (ADMIN):
                    adminMenu();
                    break;
                // If we aren't adding/returning money, we're vending an item
                // Choice-1 because the item list is 0-indexed
                default:
                    vendItem(choice);
                    break;
            }
        }
    }

    public void vendItem(int choice) {
        try {
            String itemName = service.getAllItems().get(choice - 1).getName();
            service.vendItem(itemName);
            view.displayPurchase(itemName);
        } catch (ItemNotFoundException
                | ZeroInventoryException
                | InsufficientFundsException e) {
            view.displayError(e);

        }
    }

    public void adminMenu() {
        boolean notDone = true;
        int choice;

        while (notDone) {
            choice = view.displayAdminMenuAndGetChoice();

            switch (choice) {
                case REFILL:
                    int restockLevel = view.getRefillSelection();
                    if (restockLevel > 0) {
                        service.refill(restockLevel);
                    }
                    break;

                case ADD_ITEM:
                    service.addItem(view.getNewItem());
                    break;

                case REMOVE_ITEM:
                    try {
                        service.removeItem(view.getItemToDelete(service.getAllItems()));
                    } catch (ItemNotFoundException e) {
                        view.displayError(e);
                    }
                    break;

                case EDIT_ITEM:
                    try {
                        service.updateItem(view.getEdit(service.getAllItems()));
                    } catch (ItemNotFoundException e) {
                        view.displayError(e);
                    }
                    break;

                case ADD_COINS:
                    break;
                    
                case SHOW_STOCK:
                    view.displayItemList(service.getAllItems());
                case EXIT:
                    notDone = false;
                    try {
                        service.quit();
                    } catch (VendingMachineDaoException e) {
                        view.displayError(e);
                    }
                    view.displayGoodByeMessage(service.coinReturn());
                    break;

                default:
            }
        }
    }
}
