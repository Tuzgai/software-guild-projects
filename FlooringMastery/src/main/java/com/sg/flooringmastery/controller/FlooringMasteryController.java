package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.FlooringMasteryDaoFileException;
import com.sg.flooringmastery.service.FlooringMasteryServiceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.service.ServiceImpl;
import com.sg.flooringmastery.view.FlooringMasteryView;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Stuart
 */
public class FlooringMasteryController {

    ServiceImpl service;
    FlooringMasteryView view;
    final static int DISPLAY_ORDERS = 1;
    final static int ADD_ORDER = 2;
    final static int EDIT_ORDER = 3;
    final static int REMOVE_ORDER = 4;
    final static int QUIT = 5;

    public FlooringMasteryController(ServiceImpl service, FlooringMasteryView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        int choice;
        boolean notDone = true;
        while (notDone) {
            choice = view.displayMenuAndGetChoice();

            switch (choice) {
                case DISPLAY_ORDERS:
                    displayOrders();
                    break;

                case ADD_ORDER:
                    addOrder();
                    break;

                case EDIT_ORDER:
                    editOrder();
                    break;

                case REMOVE_ORDER:
                    removeOrder();
                    break;

                case QUIT: {
                    try {
                        service.saveOrdersByDate();
                    } catch (FlooringMasteryDaoFileException e) {
                        view.displayError(e);
                    }
                }
                notDone = false;
                break;
            }
        }
    }

    public void displayOrders() {
        LocalDate date = view.getDate();
        try {
            view.displayOrderList(service.getOrdersByDate(date));
        } catch (FlooringMasteryDaoFileException e) {
            view.displayError(e);
        }
        view.displayEnterToContinue();
    }

    public void addOrder() {
        try {
            Order order = view.getNewOrderDetails(service.getProductList(), service.getTaxRates());
            if (order != null) {
                service.saveNewOrder(order);
            }
        } catch (FlooringMasteryDaoFileException e) {
            view.displayError(e);
        }
        view.displaySaveSuccess();
        view.displayEnterToContinue();
    }

    public void editOrder() {
        LocalDate date = view.getDate();
        try {
            ArrayList<Order> orderList = service.getOrdersByDate(date);
            view.displayOrderList(orderList);
            int choice = view.getChoiceToEdit(orderList.size());

            // 0 to cancel
            if (choice != 0) {
                Order newOrder = view.getEditedOrder(service.getOrderByNumber(choice), service.getProductList(), service.getTaxRates());  
                service.updateOrder(newOrder);
                view.displayOrder(newOrder);
            }
        } catch (FlooringMasteryDaoFileException | FlooringMasteryServiceException e) {
            view.displayError(e);
        }
        view.displayEnterToContinue();
    }

    public void removeOrder() {
        LocalDate date = view.getDate();
        try {
            ArrayList<Order> orderList = service.getOrdersByDate(date);
            view.displayOrderList(orderList);
            int choice = view.getChoiceToRemove(orderList.size());

            // 0 to cancel
            if (choice != 0) {
                service.removeOrder(service.getOrderByNumber(choice));
            }
        } catch (FlooringMasteryDaoFileException | FlooringMasteryServiceException e) {
            view.displayError(e);
        }
        view.displayEnterToContinue();
    }

}
