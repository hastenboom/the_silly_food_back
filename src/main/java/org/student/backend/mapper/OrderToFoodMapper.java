package org.student.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.student.backend.pojo.entity.OrderToFood;

/**
 * @author Student
 */

@Mapper
public interface OrderToFoodMapper extends BaseMapper<OrderToFood> {
}
