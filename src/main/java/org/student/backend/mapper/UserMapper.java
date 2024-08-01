package org.student.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.student.backend.pojo.entity.User;

/**
 * @author Student
 */

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectById(Long id);

    @Select("SELECT * FROM user WHERE phone = #{phone}")
    User selectByPhone(String phone);

    @Select("SELECT * FROM user WHERE phone = #{phone} AND password = #{password}")
    User selectByPhoneAndPassword(String phone, String password);

    void update(User user);


    void insert(User user);

}
