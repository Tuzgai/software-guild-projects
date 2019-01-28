package com.sg.dvdcollection.ui;

import com.sg.dvdcollection.dto.DVD;
import java.time.DateTimeException;
import java.time.LocalDate;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

/**
 *
 * @author Stuart
 */
public class DvdCollectionView {

    private UserIO io;

    public DvdCollectionView(UserIO io) {
        this.io = io;
    }

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
        String input = io.readString("Enter Title: ");
        if (input.isEmpty()) {
            input = "- No Data -";
        }
        return input;
    }

    public LocalDate getReleaseDate() {
        int year, month, day;
        boolean retry;
        LocalDate date = LocalDate.of(1900, 1, 1);

        do {
            try {
                year = io.readInt("Enter Release Year: ");
                month = io.readInt("Enter Release Month (1-12): ");
                day = io.readInt("Enter Release Day (1-31): ");
                date = LocalDate.of(year, month, day);
                retry = false;
            } catch (DateTimeException e) {
                io.println("Invalid date, please try again.");
                retry = true;
            }
        } while (retry);
        return date;
    }

    public String getRating() {
        String input = io.readString("Enter MPAA Rating: ");
        if (input.isEmpty()) {
            input = "- No Data -";
        }
        return input;
    }

    public String getStudio() {
        String input = io.readString("Enter Studio Name: ");
        if (input.isEmpty()) {
            input = "- No Data -";
        }
        return input;
    }

    public String getNote() {
        String input = io.readString("Enter Notes: ");
        if (input.isEmpty()) {
            input = "- No Data -";
        }
        return input;
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
        return response.toLowerCase().contains("y");
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
        io.println("-----Field-----|---Current Entry---");
        io.println("1. Title       |   " + dvd.getTitle());
        io.println("2. Date        |   " + dvd.getReleaseDate().format(ISO_LOCAL_DATE));
        io.println("3. Rating      |   " + dvd.getRating());
        io.println("4. Studio      |   " + dvd.getStudio());
        io.println("5. Notes       |   " + dvd.getNote());
        io.println("---------------|");
        io.println("6. Edit All    |");
        io.println("7. Exit Editor |");
        io.println("---------------|");
        return io.readInt("Select An Option: ");
    }

    public boolean promptEditContinue() {
        String choice = io.readString("Changes complete. Continue editing? (Y/N) ");
        return choice.toLowerCase().contains("y");
    }

    public void displayErrorMessage(String errorMsg) {
        io.println("=== Error ===");
        io.println(errorMsg);
    }
    
   public void displayDeleteSuccessfulBanner() {
       io.println("=== File Deleted Successfully ===");
   }
}
