package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryDao;

/**
 *
 * @author Stuart
 */
public class FlooringMasteryServiceImpl {
    FlooringMasteryDao dao;

    public FlooringMasteryServiceImpl(FlooringMasteryDao dao) {
        this.dao = dao;
    }
    
    
}
