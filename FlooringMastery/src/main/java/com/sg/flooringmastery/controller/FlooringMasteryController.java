package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.service.FlooringMasteryServiceImpl;
import com.sg.flooringmastery.view.FlooringMasteryView;

/**
 *
 * @author Stuart
 */
public class FlooringMasteryController {
    FlooringMasteryServiceImpl service;
    FlooringMasteryView view;

    public FlooringMasteryController(FlooringMasteryServiceImpl service, FlooringMasteryView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() {
        
    }
}
