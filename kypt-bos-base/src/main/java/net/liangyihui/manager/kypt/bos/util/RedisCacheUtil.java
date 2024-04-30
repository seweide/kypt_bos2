package net.liangyihui.manager.kypt.bos.util;

import net.liangyihui.digitalmarketing.common.cache.dao.RedisDao;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * 存入redis的对象中，如果有LocalDateTime，
 * 需要在该属性上添加此注解 @JsonDeserialize(using = LocalDateTimeDeserializer.class) @JsonSerialize(using = LocalDateTimeSerializer.class)
 *
 * @author liu_y
 */
public class RedisCacheUtil {

    private static final String REDIS_KEY_PREFIX = "RedisCache:";

    /**
     * 默认 expireTime=1 timeUnit=HOURS
     *
     * @param redisDao redisDao
     * @param param    入参，同时用来拼接redisKey
     * @param function 如果没有则执行该方法获取
     * @param <R>      要获取的类型
     * @param <T>      入参类型
     * @return R Object
     */
    public static <T, R> R getOrExecute(RedisDao redisDao, T param, String prefix, Function<T, R> function) {
        return getOrExecute(redisDao, 1, TimeUnit.HOURS, param, prefix, function);
    }

    /**
     * 假如function 执行结果为null，则不会缓存，如果需要缓存，可以使用emptyList等
     *
     * @param redisDao redisDao
     * @param param    入参，同时用来拼接redisKey
     * @param expire   expireTime
     * @param timeUnit timeUnit
     * @param function 如果没有则执行该方法获取
     * @param <R>      要获取的类型
     * @return R Object
     */
    public static <T, R> R getOrExecute(RedisDao redisDao, int expire,
                                        TimeUnit timeUnit,
                                        T param,
                                        String prefix,
                                        Function<T, R> function) {
        String key = REDIS_KEY_PREFIX + prefix + ":" + param;
        R result = redisDao.get(key);
        if (null != result) {
            return result;
        }
        result = function.apply(param);
        if (null == result) {
            return null;
        }
        redisDao.set(key, expire, timeUnit, result);
        return result;
    }

}
