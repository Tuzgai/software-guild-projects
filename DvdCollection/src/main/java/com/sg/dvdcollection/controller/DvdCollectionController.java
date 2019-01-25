package com.sg.dvdcollection.controller;

import com.sg.dvdcollection.dao.DvdCollectionDao;
import com.sg.dvdcollection.dao.DvdCollectionDaoFileImpl;
import com.sg.dvdcollection.dto.DVD;
import com.sg.dvdcollection.ui.DvdCollectionView;
import com.sg.dvdcollection.ui.UserIO;
import com.sg.dvdcollection.ui.UserIOConsoleImpl;

/**
 *
 * @author Stuart
 */
public class DvdCollectionController {

    UserIO io = new UserIOConsoleImpl();
    DvdCollectionView view;
    DvdCollectionDao dao;

    public DvdCollectionController() {
        this.dao = new DvdCollectionDaoFileImpl();
        this.view = new DvdCollectionView();
    }

    public void run() {
        int choice;
        boolean notDone = true;

        while (notDone) {
            choice = view.displayMenuAndGetSelection();

            switch (choice) {
                case 1:
                    addDvd();
                    break;
                case 2:
                    io.println("REMOVE DVD");
                    break;
                case 3:
                    io.println("EDIT DVD");
                    break;
                case 4:
                    displayAllDvds();
                    break;
                case 5:
                    displayDvd();
                    break;
                case 6:
                    io.println("EXIT");
                    notDone = false;
                default:
                    io.println("UNKNOWN COMMAND");
                    break;
            }
        }
    }

    private void addDvd() {
        DVD newDvd = view.getNewDvdInfo(); // not sure why view isn't found w/o this
        dao.addDvd(newDvd.getTitle(), newDvd);
    }
    
    private void displayDvd() {
        String title = view.getTitle();
        DVD dvd = dao.getDvd(title);
        
        if(dvd != null) {
            view.displayDvd(dvd);
        } else {
            view.displayMissingDvdError();
        }
    }
    
    private void displayAllDvds() {
        view.displayDvdListBanner();
        
        for(DVD dvd : dao.getAllDvds()) {
            view.displaySectionBreak();
            view.displayDvd(dvd);
        }
    }
}
