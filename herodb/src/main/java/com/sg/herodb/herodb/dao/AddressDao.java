package com.sg.herodb.herodb.dao;

import com.sg.herodb.herodb.entity.Address;
import java.util.List;

/**
 *
 * @author Stuart
 */
public interface AddressDao {
    Address getAddressById(int id);
    List<Address> getAllAddresses();
    Address createAddress(Address address);
    void updateAddress(Address address);
    void deleteAddress(Address address);
    
    List<Address> getAddressByHeroId(int id);
}
