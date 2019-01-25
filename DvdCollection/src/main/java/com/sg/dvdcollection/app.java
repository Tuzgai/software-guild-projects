package com.sg.dvdcollection;

import com.sg.dvdcollection.controller.DvdCollectionController;

/**
 *
 * @author Stuart
 */
public class app {
    public static void main(String[] args) {
        DvdCollectionController controller = new DvdCollectionController();
        
        controller.run();
    }
}
