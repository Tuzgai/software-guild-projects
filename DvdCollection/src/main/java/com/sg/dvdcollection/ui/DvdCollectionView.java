package com.sg.dvdcollection.ui;

import com.sg.dvdcollection.dto.DVD;
import java.time.LocalDate;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

/**
 *
 * @author Stuart
 */
public class DvdCollectionView {

    UserIO io = new UserIOConsoleImpl();

    public int displayMenuAndGetSelection() {
        io.println("1. Add DVD");
        io.println("2. Remove DVD");
        io.println("3. Edit DVD");
        io.println("4. List Collection");
        io.println("5. Display DVD Info");
        io.println("6. Exit");
        return io.readInt("Enter your choice: ");
    }

    // TODO: handle improper date entry
    public DVD getNewDvdInfo() {
        io.println("=== DVD Entry Form ===");
        String title = io.readString("Enter DVD Title (required): ");
        int year = io.readInt("Enter Release Year: ");
        int month = io.readInt("Enter Release month (1-12): ");
        int day = io.readInt("Enter Release day (1-31): ");
        String rating = io.readString("Enter MPAA Rating: ");
        String studio = io.readString("Enter Studio Name: ");
        String note = io.readString("Enter Notes: ");
        LocalDate date = LocalDate.of(year, month, day);

        DVD newDvd = new DVD(title);
        newDvd.setReleaseDate(date);
        newDvd.setRating(rating);
        newDvd.setStudio(studio);
        newDvd.setNote(note);
        io.println("=== Information Entered Successfully! ===");

        return newDvd;
    }

    public void displayDvd(DVD dvd) {
        io.println("Title: " + dvd.getTitle());
        io.println("Release Date: " + 
                dvd.getReleaseDate().format(ISO_LOCAL_DATE));
        io.println("MPAA Rating: " + dvd.getRating());
        io.println("Studio: " + dvd.getStudio());
        io.println("Notes: " + dvd.getNote());
    }

    public void displayDvdBanner() {
        io.println("=== DVD Details ===");
    }
    
    public String getTitle() {
        return io.readString("Enter title: ");
    }
    
    public void displayMissingDvdError() {
        io.println("DVD not found, returning to main menu...");
    }
    
    public void displaySectionBreak() {
        io.println("---------------------------------------------");
    }
    
    public void displayDvdListBanner() {
        io.println("=== Full DVD List ===");
    }
}
