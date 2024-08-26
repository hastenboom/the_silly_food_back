package org.student.backend.login.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.student.backend.login.LoginFormDTO;
import org.student.backend.login.UserDTO;
import org.student.backend.mapper.UserMapper;
import org.student.backend.pojo.common.Result;
import org.student.backend.pojo.entity.User;
import org.student.backend.util.MyBeanUtil;
import org.student.backend.util.regex.RegexUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.student.backend.util.redis.RedisConstant.*;

/**
 * @author Student
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private UserMapper userMapper;

    @Override
    public Result sendCode(String phone) {
        //1. verify the phone format;
        if (RegexUtils.isPhoneInvalid(phone)) {
            return Result.fail("wrong phone format");
        }

        //2. generate the code, and storePhoneAndCode();
        //FIXME: length 2 for debug purpose
        String code = RandomUtil.randomNumbers(2);
        stringRedisTemplate.opsForValue().set(CACHE_LOGIN_CODE + phone, code, CACHE_LOGIN_CODE_TTL, TimeUnit.SECONDS);

        //3. send the code back to the front-end
        //! in practice, we should use an SMS service to send the code to the phone
        log.info("send code to phone: {}, code: {}", phone, code);

        return Result.ok();
    }

    @Override
    @Transactional
    public Result login(LoginFormDTO loginFormDTO) {

        String phone = loginFormDTO.getPhone();
        if (RegexUtils.isPhoneInvalid(phone)) {
            return Result.fail("wrong phone format");
        }

        if (loginFormDTO.getPassword() == null || loginFormDTO.getPassword().isEmpty()) {

            return handleCodeMode(loginFormDTO);
        }

        else {
            return handlePasswordMode(loginFormDTO);
        }
    }

    public Result handlePasswordMode(LoginFormDTO loginFormDTO) {
        String phone = loginFormDTO.getPhone();
        String password = loginFormDTO.getPassword();

        User user = userMapper.selectByPhoneAndPassword(phone, password);
        if (user == null) {
            return Result.fail("wrong phone or password");
        }

        return Result.ok(createKeyHashCacheForUserDTO(user));
    }


    /**
     * <ol>
     *     <li>check the key-value:phone-code in redis, if (not exist) || (code!=cacheCode) , return error</li>
     *     <li>if redis is ok, check the user in db. If not exist, create a new user and insert into db; else
     *     manipulate the user data</li>
     *     <li>Cache the key-hash: cache:login:user:randomToken-userDTOMap(transformed from user data), and return
     *     the randomToken to the front-end</li>
     *     <li>The interceptor is responsible for checking the token in header: token:{randomToken}</li>
     * </ol>
     *
     * @param loginFormDTO
     * @return
     */
    public Result handleCodeMode(LoginFormDTO loginFormDTO) {

        String phone = loginFormDTO.getPhone();
        String code = loginFormDTO.getCode();

        String cacheCode = stringRedisTemplate.opsForValue().get(CACHE_LOGIN_CODE + phone);
        if (cacheCode == null) {
            return Result.fail("code expired or not exist");
        }
        if (!cacheCode.equals(code)) {
            return Result.fail("error code");
        }


        User user = userMapper.selectByPhone(phone);

        //additional process: register a new user if not exist
        if (user == null) {

            user = new User();
            user.setPhone(phone);
            user.setRole(loginFormDTO.getRole());
            user.setFullName("user_" + RandomUtil.randomString(5));

            //insert into db
            userMapper.insert(user);
        }

        return Result.ok(createKeyHashCacheForUserDTO(user));
    }

    public String createKeyHashCacheForUserDTO(User user) {
        // handle with cache
        // key-hash: cache:login:user:randomToken-userDTOMap
        String randomToken
                = UUID.randomUUID().toString();
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);

        Map<String, String> userDTOMap = MyBeanUtil.stringBeanToMap(userDTO);

        stringRedisTemplate.opsForHash()
                .putAll(CACHE_LOGIN_USER + randomToken, userDTOMap);

        stringRedisTemplate.expire(CACHE_LOGIN_USER + randomToken, CACHE_LOGIN_USER_TTL, TimeUnit.MINUTES);

        return randomToken;
    }
}



