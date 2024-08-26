package org.student.backend.util.redis;

/**
 * @author Student
 */
public class RedisConstant {
    public static final String REDIS_HOST = "localhost";


    public static final String CACHE_LOGIN_CODE = "cache:login:code:";
    /*TimeUnit.SECONDS*/
    /*fixme: debug purpose, change it back to 70s*/
    public static final Long CACHE_LOGIN_CODE_TTL = 7000L;

    public static final String CACHE_LOGIN_USER = "cache:login:user:";
    /*TimeUnit.DAYS*/
    public static final Long CACHE_LOGIN_USER_TTL = 30000L;
}
