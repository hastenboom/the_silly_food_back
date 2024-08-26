package org.student.backend.address.service;

import org.student.backend.pojo.common.Result;
import org.student.backend.pojo.entity.Address;

/**
 * @author Student
 */
public interface AddressService {

    Result getAddressListByUserId();

    Result insertAddress(Address address);
}
