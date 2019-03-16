package com.sg.herodb.herodb.dao;

import com.sg.herodb.herodb.entity.Superhero;
import java.util.List;

/**
 *
 * @author Stuart
 */
public interface SuperheroDao {
    Superhero getSupeheroById(int id);
    List<Superhero> getAllSuperheroes();
    Superhero createSuperhero(Superhero superhero);
    void updateSuperhero(Superhero superhero);
    void deleteSuperhero(Superhero superhero);
    
    List<Superhero> getSuperheroesByAddressId(int addressId);
}
