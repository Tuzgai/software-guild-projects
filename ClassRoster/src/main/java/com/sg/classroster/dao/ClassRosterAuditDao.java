package com.sg.classroster.dao;

/**
 *
 * @author Stuart
 */
public interface ClassRosterAuditDao {
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
}
