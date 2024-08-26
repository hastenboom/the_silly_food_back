package org.student.backend.interceptor;

import cn.hutool.core.bean.BeanUtil;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.student.backend.login.UserDTO;
import org.student.backend.login.UserDTOHolder;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.student.backend.util.redis.RedisConstant.CACHE_LOGIN_USER;
import static org.student.backend.util.redis.RedisConstant.CACHE_LOGIN_USER_TTL;

/**
 * @author Student
 */
@RequiredArgsConstructor
public class RefreshTokenInterceptor implements HandlerInterceptor {

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getMethod().equals("OPTIONS")){
            return true;
        }

        String randomToken = request.getHeader("random-token");

        //randomToken exists
        if (StringUtils.isNotBlank(randomToken)) {

            Map<Object, Object> userDTOMap = stringRedisTemplate.opsForHash().entries(CACHE_LOGIN_USER + randomToken);

            if (userDTOMap != null && !userDTOMap.isEmpty()) {
                UserDTO userDTO = BeanUtil.fillBeanWithMap(userDTOMap, new UserDTO(), false);
                stringRedisTemplate.expire(CACHE_LOGIN_USER + randomToken, CACHE_LOGIN_USER_TTL, TimeUnit.MINUTES);
                UserDTOHolder.saveUser(userDTO);
            }
            else {
                return true;
            }
        }
        // no token
        else {
            return true;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception
    {
        UserDTOHolder.removeUser();
    }
}
