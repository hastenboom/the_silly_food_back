package org.student.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.student.backend.pojo.entity.Restaurant;

/**
 * @author Student 
 */
@Mapper
public interface RestaurantMapper extends BaseMapper<Restaurant> {
}
