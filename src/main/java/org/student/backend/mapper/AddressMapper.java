package org.student.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.student.backend.pojo.entity.Address;

/**
 * @author Student
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {
}
