package com.drools.service.redis;

import com.drools.model.constant.RedisType;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 描述：Redis接口
 * CLASSPATH: IRedisService
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface IRedisService {

    /*
     * ==============================Hash接口===================================
     */

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据Key查找对应的value
     *
     * @param key  key
     * @param type 枚举类型
     */
    String get(RedisType type, String key);

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据Key查找所有的value集合
     *
     * @param type 枚举类型
     */
    List<String> getValues(RedisType type);

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据Key查找所有的value集合
     *
     * @param type 枚举类型
     */
    Map<String, String> getAll(RedisType type);

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 向Redis中添加一条永久记录
     *
     * @param key   key
     * @param value value
     * @param type  枚举类型
     */
    void put(RedisType type, String key, String value);

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 向Redis中添加一条永久记录
     *
     * @param map  value
     * @param type 枚举类型
     */
    void putAll(RedisType type, Map<String, String> map);

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据key删除redis中的记录
     *
     * @param key  key
     * @param type 枚举类型
     */
    void remove(RedisType type, String key);

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据key删除redis中的记录
     *
     * @param type 枚举类型
     */
    void removeAll(RedisType type);

    /*
     * ==============================String接口===================================
     */

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 向Redis中添加一条永久记录
     *
     * @param key   key
     * @param value value
     */
    void put(String key, String value);

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 向Redis中添加一条记录,并设置有效时间
     *
     * @param key         key
     * @param value       value
     * @param expiredTime 有效时间
     * @param unit        时间格式工具类
     */
    void put(String key, String value, long expiredTime, TimeUnit unit);

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据可以获取value
     *
     * @param key key
     */
    String get(String key);

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据key删除redis中的记录
     *
     * @param key key
     */
    void delete(String key);

}
