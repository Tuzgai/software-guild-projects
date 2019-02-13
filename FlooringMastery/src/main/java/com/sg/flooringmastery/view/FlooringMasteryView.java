package com.sg.flooringmastery.view;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.ProductType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Stuart
 */
public class FlooringMasteryView {

    UserIO io;

    public FlooringMasteryView(UserIO io) {
        this.io = io;
    }

    public void displayEnterToContinue() {
        io.println("Press enter to continue.");
    }

    public void displayError(Exception e) {
        io.println(e.getMessage());
    }

    public int displayMenuAndGetChoice() {
        io.println("+------------------------------+");
        io.println("|    Flooring Order Tracker    |");
        io.println("|                              |");
        io.println("| 1. Display Orders            |");
        io.println("| 2. Add an Order              |");
        io.println("| 3. Edit an Order             |");
        io.println("| 4. Remove an Order           |");
        io.println("| 5. Quit                      |");
        io.println("|                              |");
        io.println("+------------------------------+");
        return io.readInt("Enter your selection: ", 1, 5);
    }

    public LocalDate getDate() {
        return io.readLocalDate();
    }

    public void displayOrderList(ArrayList<Order> orderList) {
        orderList.forEach(item -> displayOrder(item));
        io.println("+-------------------------------------------------------------------------------------+");
    }

    public int getChoiceToRemove(int numberOfChoices) {
        int choice = io.readInt("Select an order to remove (0 to cancel): ", 1, numberOfChoices);
        while (true) {
            String confirm = io.readString("Are you sure you want to delete this entry? (Y/N):");
            if (confirm.toLowerCase().contains("y")) {
                return choice;
            } else if (confirm.toLowerCase().contains("n")) {
                io.println("Ok, order will not be deleted.");
                return 0;
            }
        }
    }

    public Order getNewOrderDetails(ArrayList<ProductType> productList, HashMap<String, BigDecimal> taxRates) {
        LocalDate date = LocalDate.now();
        Order order = new Order();

        order.setDate(date);
        order.setCustName(io.readString("Enter Customer Name: "));
        String taxState = displayStatesAndGetSelection(taxRates);
        BigDecimal tax = taxRates.get(taxState);
        int productChoice = displayProductsAndGetSelection(productList);
        ProductType product = productList.get(productChoice);
        order.setState(taxState);
        order.setTaxRate(tax);
        order.setProductType(product);
        order.setAreaSquareFeet(io.readBigDecimal("Enter area (sqft): "));
        order.updateDerivedFields();

        displayOrder(order);

        String confirm = io.readString("Are you sure you want to save this entry? (Y/N):");
        while (true) {
            if (confirm.toLowerCase().contains("y")) {
                return order;
            } else if (confirm.toLowerCase().contains("n")) {
                io.println("Ok, order will not be added.");
                return null;
            }
        }
    }

    public String displayStatesAndGetSelection(HashMap<String, BigDecimal> taxRates) {
        io.println("+----------------+");
        io.println("| State  Tax     |");

        taxRates.forEach((k, v) -> {
            io.println("| " + k + "     " + v + "    ");
        });

        String choice = "";
        while (!taxRates.containsKey(choice)) {
            choice = io.readString("Select a state (two letter code): ");
        }
        return choice;
    }

    public int displayProductsAndGetSelection(ArrayList<ProductType> productList) {
        io.println("+---------------------+");
        io.println("|   Product    Material Cost (sqft)    Labor Cost (sqft)");

        productList.forEach(item -> {
            io.println(productList.indexOf(item) + ". " + item.getName() + "\t" + item.getMaterialCostPerSquareFoot() + "\t" + item.getLaborCostPerSquareFoot());
        });

        return io.readInt("Select a product: ", 1, productList.size()) - 1;
    }

    public void displayOrder(Order order) {
        io.println("+-------------------------------------------------------------------------------------+");
        io.println("| Order Number: " + order.getOrderNumber() + "\tCustomer Name" + order.getCustName());
        io.println("| State: " + order.getState() + "\tTax Rate: " + order.getTaxRate());
        io.println("| Product Type: " + order.getProductType() + "\tMaterial Cost(sqft): $" + order.getMaterialCostPerSquareFoot()
                + "\tLabor Cost(sqft): $" + order.getLaborCost());
        io.println("| \t\t\tMaterial Cost: $" + order.getMaterialCost() + "\t\tLabor Cost: $" + order.getLaborCost());
        io.println("| Area: " + order.getAreaSquareFeet() + " sqft");
        io.println("| Tax: $" + order.getTaxPaid());
        io.println("| Total: $" + order.getTotal());
    }
}
