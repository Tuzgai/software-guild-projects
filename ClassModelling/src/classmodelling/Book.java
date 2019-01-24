package classmodelling;

import java.util.Date;

/**
 *
 * @author Stuart
 */
public class Book {
    private String title, author;
    private String [] textByChapter;
    private Date lastSubmissionDate, deadline;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getTextByChapter() {
        return textByChapter;
    }

    public void setTextByChapter(String[] textByChapter) {
        this.textByChapter = textByChapter;
    }

    public Date getLastSubmissionDate() {
        return lastSubmissionDate;
    }

    public void setLastSubmissionDate(Date lastSubmissionDate) {
        this.lastSubmissionDate = lastSubmissionDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
    
}
