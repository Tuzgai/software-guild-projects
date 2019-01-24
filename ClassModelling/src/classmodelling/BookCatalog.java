package classmodelling;

import java.util.Date;

/**
 *
 * @author Stuart
 */
public class BookCatalog {
    private final String title;
    private final String author;
    private final Date publicationDate;
    private String [] genres;
    private boolean checkedOut;
    private Date dueDate;
    private double fine;

    public BookCatalog(String title, String author, Date publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }
    
    public void addGenre(String genre) {
        
    }
    
    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
    
    
}
