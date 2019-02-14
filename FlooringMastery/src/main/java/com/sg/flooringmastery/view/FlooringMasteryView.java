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
        io.readString("Press enter to continue.");
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

    public int getChoiceToEdit(int numberOfChoices) {
        return io.readInt("Select an order to edit (0 to cancel): ", 1, numberOfChoices);
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
        io.println("+-------------------------------------------------------------------------------------+");
        String confirm = io.readString("Are you sure you want to save this entry? (Y/N): ");
        while (true) {
            if (confirm.toLowerCase().contains("y")) {
                return order;
            } else if (confirm.toLowerCase().contains("n")) {
                io.println("Ok, order will not be added.");
                return null;
            }
        }
    }

    public void displayStates(HashMap<String, BigDecimal> taxRates) {
        io.println("+----------------+");
        io.println("| State  Tax     |");

        taxRates.forEach((k, v) -> {
            io.println("| " + k + "     " + v + "    |");
        });
        io.println("+----------------+");

    }

    public String displayStatesAndGetSelection(HashMap<String, BigDecimal> taxRates) {
        displayStates(taxRates);
        String choice = "";
        do {
            choice = io.readString("Select a state (two letter code): ");
        } while (!taxRates.containsKey(choice));
        return choice;
    }

    public String displayStatesAndGetSelectionEditMode(HashMap<String, BigDecimal> taxRates, String state) {
        displayStates(taxRates);

        String choice = "";
        do {
            choice = io.readString("Select a state " + "(" + state + "): ");
        } while (!(taxRates.containsKey(choice) || choice.equals("\n")));
        return choice;
    }

    public void displayProducts(ArrayList<ProductType> productList) {
        io.println("+-------------------------------------------------------+");
        io.println("|  Product    Material Cost (sqft)    Labor Cost (sqft) |");

        productList.forEach(item -> {
            io.println("| " + productList.indexOf(item) + ". " + item.getName() 
                    + "\t$" + item.getMaterialCostPerSquareFoot() 
                    + "\t\t\t$" + item.getLaborCostPerSquareFoot() + "           |");
        });

        io.println("+-------------------------------------------------------+");

    }

    public int displayProductsAndGetSelection(ArrayList<ProductType> productList) {
        displayProducts(productList);

        return io.readInt("Select a product: ", 1, productList.size()) - 1;
    }

    public int displayProductsAndGetSelectionEditMode(ArrayList<ProductType> productList, ProductType product) {
        displayProducts(productList);

        int choice;
        String input;
        do {
            input = io.readString("Select A Product" + "(" + product.getName() + "): ");
            try {
                choice = Integer.parseInt(input);

                // Return if re get a valid selection
                if (0 < choice && choice < productList.size()) {
                    return choice - 1;
                }
            } catch (NumberFormatException e) {
                // Do nothing, just loop again
            }

            // Return -1 if we get a newline
        } while (!input.equals("\n"));

        return -1;
    }

    public void displayOrder(Order order) {
        io.println("+-------------------------------------------------------------------------------------+");
        io.println("| Order Number: " + order.getOrderNumber() + "\tCustomer Name: " + order.getCustName());
        io.println("| State: " + order.getState() + "\tTax Rate: " + order.getTaxRate() + "%");
        io.println("| Product Type: " + order.getProductType().getName() + "\tMaterial Cost(sqft): $" + order.getMaterialCostPerSquareFoot()
                + "\tLabor Cost(sqft): $" + order.getLaborCostPerSquareFoot());
        io.println("| Area: " + order.getAreaSquareFeet() + " sqft");
        io.println("| Material Cost: $" + order.getMaterialCost());  
        io.println("| Labor Cost: \t $" + order.getLaborCost());
        io.println("| Subtotal:\t $" + order.getMaterialCost().add(order.getLaborCost()));
        io.println("| Tax: \t\t $" + order.getTaxPaid());
        io.println("| Total:\t $" + order.getTotal());
    }

    public Order getEditedOrder(Order order, ArrayList<ProductType> productList, HashMap<String, BigDecimal> taxRates) {
        io.println("=== EDIT AN ORDER ===");
        io.println("Enter new value or return to skip.");

        String name = io.readString("Enter Customer Name " + "(" + order.getCustName() + "): ");
        String taxState = displayStatesAndGetSelectionEditMode(taxRates, order.getState());

        int productChoice = displayProductsAndGetSelectionEditMode(productList, order.getProductType());
        BigDecimal area = io.readBigDecimalOrNewline("Enter Area" + "(" + order.getAreaSquareFeet() + "): ");
        String recalculate = io.readString("Update calculated fields? (Y/N - default Y) ");

        if (!name.equals("\n")) {
            order.setCustName(name);
        }

        if (!taxState.equals("\n")) {
            order.setState(taxState);
            order.setTaxRate(taxRates.get(taxState));
        }

        if (productChoice != -1) {
            ProductType product = productList.get(productChoice);
            order.setProductType(product);
        }

        if (area != null) {
            order.setAreaSquareFeet(area);
        }

        if (!recalculate.toLowerCase().contains("n")) {
            order.updateDerivedFields();
        }
        
        return order;
    }
    
    public void displaySaveSuccess() {
        io.println("Order saved!");
    }
}
