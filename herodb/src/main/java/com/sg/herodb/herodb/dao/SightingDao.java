package com.sg.herodb.herodb.dao;

import com.sg.herodb.herodb.entity.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Stuart
 */
public interface SightingDao {
    Sighting getSightingById(int id);
    List<Sighting> getAllSightings();
    Sighting createSighting(Sighting sighting);
    void updateSighting(Sighting sighting);
    void deleteSighting(Sighting sighting);
    
    List<Sighting> getSightingsByDate(LocalDate date);
}
