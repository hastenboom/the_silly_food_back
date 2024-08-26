package org.student.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.student.backend.pojo.entity.Order;

/**
 * @author Student
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
