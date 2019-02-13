package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.service.ServiceImpl;
import com.sg.flooringmastery.view.FlooringMasteryView;

/**
 *
 * @author Stuart
 */
public class FlooringMasteryController {
    ServiceImpl service;
    FlooringMasteryView view;

    public FlooringMasteryController(ServiceImpl service, FlooringMasteryView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() {
        
    }
}
