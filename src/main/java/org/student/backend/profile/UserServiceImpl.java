package org.student.backend.profile;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.student.backend.login.UserDTO;
import org.student.backend.login.UserDTOHolder;
import org.student.backend.pojo.common.Result;

import static org.student.backend.util.redis.RedisConstant.CACHE_LOGIN_USER;

/**
 * @author Student
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result getClientProfile() {
        UserDTO user = UserDTOHolder.getUser();
        return Result.ok(user);
    }

    @Override
    public Result logoutFromClientProfile(HttpServletRequest request) {

        String randomToken = request.getHeader("random-token");
        stringRedisTemplate.delete(CACHE_LOGIN_USER + randomToken);

        return Result.ok();
    }
}
