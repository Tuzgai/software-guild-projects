package com.sg.dvdcollection.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Stuart
 */
public class DVD {
    private String title;
    private LocalDate releaseDate;
    private String rating;
    private String studio;
    private String note;
    
    public DVD (String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }   
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.title);
        hash = 59 * hash + Objects.hashCode(this.releaseDate);
        hash = 59 * hash + Objects.hashCode(this.rating);
        hash = 59 * hash + Objects.hashCode(this.studio);
        hash = 59 * hash + Objects.hashCode(this.note);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        return true;
    }
    
    
}
