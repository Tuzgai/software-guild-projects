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
        io.println("=== Main Menu ===");
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
        DVD newDvd = new DVD(getTitle());
        newDvd.setReleaseDate(getReleaseDate());
        newDvd.setRating(getRating());
        newDvd.setStudio(getStudio());
        newDvd.setNote(getNote());
        io.println("=== Information Entered Successfully! ===");

        return newDvd;
    }

    public String getTitle() {
        return io.readString("Enter title: ");
    }

    public LocalDate getReleaseDate() {
        int year = io.readInt("Enter Release Year: ");
        int month = io.readInt("Enter Release Month (1-12): ");
        int day = io.readInt("Enter Release Day (1-31): ");
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }

    public String getRating() {
        return io.readString("Enter MPAA Rating: ");
    }

    public String getStudio() {
        return io.readString("Enter Studio Name: ");
    }

    public String getNote() {
        return io.readString("Enter Notes: ");
    }

    public void displayDvd(DVD dvd) {
        io.println("--- " + dvd.getTitle() + " ---");
        io.println("Release Date: "
                + dvd.getReleaseDate().format(ISO_LOCAL_DATE));
        io.println("MPAA Rating: " + dvd.getRating());
        io.println("Studio: " + dvd.getStudio());
        io.println("Notes: " + dvd.getNote());
    }

    public void displayDvdBanner() {
        io.println("=== DVD Details ===");
    }

    public void displayMissingDvdError() {
        io.println("DVD not found, returning to main menu...");
        continuePrompt();
    }

    public void displaySectionBreak() {
        io.println("---------------------------------------------");
    }

    public void displayDvdListBanner() {
        io.println("=== Full DVD List ===");
    }

    public void continuePrompt() {
        io.readString("Press Enter To Continue");
        io.println("");
    }

    public void displayRemoveDvdBanner() {
        io.println("=== Remove DVD from Collection ===");
    }

    public boolean getDeleteConfirmation(DVD dvd) {
        displayDvd(dvd);
        String response = io.readString("Are you sure you want to delete this? (Y/N) ");
        if (response.toLowerCase().contains("y")) {
            return true;
        }

        return false;
    }

    public void displayDeleteCancelled() {
        io.println("Ok, cancelling...");
    }

    public void displayGoodbyeMessage() {
        io.println("Thank you and good bye!");
    }

    public void displayUnknownCommandMessage() {
        io.println("Unknown command! Please enter a valid response.");
    }

    public int displayEditMenuAndGetChoice(DVD dvd) {
        io.println("=== Edit A DVD ===");
        io.println("---Field---\t---Current Entry---");
        io.println("1. Title\t" + dvd.getTitle());
        io.println("2. Date\t" + dvd.getReleaseDate().format(ISO_LOCAL_DATE));
        io.println("3. Rating\t" + dvd.getRating());
        io.println("4. Studio\t" + dvd.getStudio());
        io.println("5. Notes\t" + dvd.getNote());
        io.println("6. Edit All");
        io.println("7. Exit Editor");
        return io.readInt("Select an option: ");
    }

    public boolean promptEditContinue() {
        String choice = io.readString("Changes complete. Continue editing? (Y/N) ");
        if (choice.toLowerCase().contains("y")) {
            return true;
        }

        return false;
    }
}
