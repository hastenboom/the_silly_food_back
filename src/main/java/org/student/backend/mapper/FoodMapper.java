package org.student.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.student.backend.pojo.entity.Food;

/**
 * @author Student
 */
@Mapper
public interface FoodMapper extends BaseMapper<Food> {
}
