package org.student.backend.address.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.student.backend.login.UserDTOHolder;
import org.student.backend.mapper.AddressMapper;
import org.student.backend.pojo.common.Result;
import org.student.backend.pojo.entity.Address;

import java.util.List;

/**
 * @author Student
 */
@Service
public class AddressServiceImpl implements AddressService {


    @Resource
    private AddressMapper addressMapper;


    @Override
    public Result getAddressListByUserId() {

        Long userId = UserDTOHolder.getUser().getId();

        List<Address> addressList = addressMapper.selectList(
                new QueryWrapper<Address>()
                        .eq("user_id", userId)
        );

        return Result.ok(addressList);
    }

    @Override
    public Result insertAddress(Address address) {
        System.out.println(address);
        Long userId = UserDTOHolder.getUser().getId();
//        address.setId(123L);
        address.setUserId(userId);
        addressMapper.insert(address);
        return Result.ok();
    }
}
