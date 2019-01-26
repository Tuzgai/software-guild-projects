package com.sg.dvdcollection.controller;

import com.sg.dvdcollection.dao.DvdCollectionDao;
import com.sg.dvdcollection.dao.DvdCollectionDaoFileImpl;
import com.sg.dvdcollection.dto.DVD;
import com.sg.dvdcollection.ui.DvdCollectionView;

/**
 *
 * @author Stuart
 */
public class DvdCollectionController {

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
                    removeDvd();
                    break;
                case 3:
                    editDvd();
                    break;
                case 4:
                    displayAllDvds();
                    break;
                case 5:
                    displayDvd();
                    break;
                case 6:
                    view.displayGoodbyeMessage();
                    notDone = false;
                    break;
                default:
                    view.displayUnknownCommandMessage();
                    break;
            }
        }
    }

    private void addDvd() {
        DVD newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.continuePrompt();
    }

    private void displayDvd() {
        String title = view.getTitle();
        DVD dvd = dao.getDvd(title);

        if (dvd != null) {
            view.displayDvd(dvd);
        } else {
            view.displayMissingDvdError();
        }
        view.continuePrompt();
    }

    private void displayAllDvds() {
        view.displayDvdListBanner();

        for (DVD dvd : dao.getAllDvds()) {
            view.displaySectionBreak();
            view.displayDvd(dvd);
        }
        view.continuePrompt();
    }

    private void removeDvd() {
        view.displayRemoveDvdBanner();
        String title = view.getTitle();
        DVD dvd = dao.getDvd(title);
        boolean confirm;

        if (dvd != null) {
            confirm = view.getDeleteConfirmation(dvd);

            if (confirm == true) {
                dao.removeDvd(title);
            } else {
                view.displayDeleteCancelled();
            }
        } else {
            view.displayMissingDvdError();
        }
    }

    private void editDvd() {
        String title = view.getTitle();
        DVD dvd = dao.getDvd(title);
        boolean notDone = true;
        int choice;
        if (dvd != null) {
            while (notDone) {
                choice = view.displayEditMenuAndGetChoice(dvd);

                switch (choice) {
                    case 1:
                        dvd.setTitle(view.getTitle());
                        break;
                    case 2:
                        dvd.setReleaseDate(view.getReleaseDate());
                        break;
                    case 3:
                        dvd.setRating(view.getRating());
                        break;
                    case 4:
                        dvd.setStudio(view.getStudio());
                        break;
                    case 5:
                        dvd.setNote(view.getNote());
                        break;
                    case 6:
                        addDvd();
                        break;
                    default:
                        notDone = false;
                        break;
                }
                dao.addDvd(dvd.getTitle(), dvd);
                if (notDone == true) {
                    notDone = view.promptEditContinue();
                }
            }
        } else {
            view.displayMissingDvdError();
            return;
        }
    }
}
