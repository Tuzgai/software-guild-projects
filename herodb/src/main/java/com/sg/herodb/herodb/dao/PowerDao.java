package com.sg.herodb.herodb.dao;

import com.sg.herodb.herodb.entity.Power;
import java.util.List;

/**
 *
 * @author Stuart
 */
public interface PowerDao {
    Power getPowerById(int id);
    List<Power> getAllPowers();
    Power createPower(Power power);
    void updatePower(Power power);
    void deletePower(int id);
}
