package com.sg.dvdcollection;

import com.sg.dvdcollection.controller.DvdCollectionController;
import com.sg.dvdcollection.dao.DvdCollectionDao;
import com.sg.dvdcollection.dao.DvdCollectionDaoFileImpl;
import com.sg.dvdcollection.ui.DvdCollectionView;
import com.sg.dvdcollection.ui.UserIO;
import com.sg.dvdcollection.ui.UserIOConsoleImpl;

/**
 *
 * @author Stuart
 */
public class app {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        DvdCollectionDao dao = new DvdCollectionDaoFileImpl();
        DvdCollectionView view = new DvdCollectionView(io);
        DvdCollectionController controller = new DvdCollectionController(dao, view);
        
        controller.run();
    }
}
