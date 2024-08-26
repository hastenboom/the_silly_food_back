package org.student.backend.address;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.student.backend.address.service.AddressService;
import org.student.backend.pojo.common.Result;
import org.student.backend.pojo.entity.Address;

/**
 * @author Student
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Resource
    private AddressService addressService;

    @GetMapping
    public Result getAddressListByUserId() {
        return addressService.getAddressListByUserId();
    }

    @PostMapping
    public Result  insertAddress(@RequestBody Address address) {
       return addressService.insertAddress(address);
    }
}

