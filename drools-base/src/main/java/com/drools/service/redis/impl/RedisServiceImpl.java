package com.drools.service.redis.impl;

import com.drools.exception.ExceptionEnum;
import com.drools.exception.ServiceException;
import com.drools.model.constant.RedisType;
import com.drools.service.redis.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 描述：
 * CLASSPATH: com.drools.service.redis.impleImpl
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
@Service
public class RedisServiceImpl implements IRedisService {


    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisServiceImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据Key查找对应的value
     *
     * @param type 枚举类型
     * @param key  key
     */
    @Override
    public String get(RedisType type, String key) {
        checkKey(key);
        return (String) this.stringRedisTemplate.opsForHash().get(type.getKeyName(), key);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据Key查找所有的value集合
     *
     * @param type 枚举类型
     */
    @Override
    public List<String> getValues(RedisType type) {
        List<Object> list = this.stringRedisTemplate.opsForHash().values(type.getKeyName());
        if (null == list || list.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> valueList = new ArrayList<>();
        for (Object obj : list) {
            valueList.add(String.valueOf(obj));
        }
        return valueList;
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据Key查找所有的value集合
     *
     * @param type 枚举类型
     */
    @Override
    public Map<String, String> getAll(RedisType type) {
        Map<Object, Object> entries = this.stringRedisTemplate.opsForHash().entries(type.getKeyName());
        if (null == entries || entries.isEmpty()) {
            return new HashMap<>();
        }
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : entries.entrySet()) {
            map.put(String.valueOf(entry.getKey()), (String) entry.getValue());
        }
        return map;
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 向Redis中添加一条永久记录
     *
     * @param type  枚举类型
     * @param key   key
     * @param value value
     */
    @Override
    public void put(RedisType type, String key, String value) {
        checkKey(key);
        this.stringRedisTemplate.opsForHash().put(type.getKeyName(), key, value);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 向Redis中添加一条永久记录
     *
     * @param type 枚举类型
     * @param map  value
     */
    @Override
    public void putAll(RedisType type, Map<String, String> map) {
        this.stringRedisTemplate.opsForHash().putAll(type.getKeyName(), map);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据key删除redis中的记录
     *
     * @param type 枚举类型
     * @param key  key
     */
    @Override
    public void remove(RedisType type, String key) {
        this.stringRedisTemplate.opsForHash().delete(type.getKeyName(), key);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据key删除redis中的记录
     *
     * @param type 枚举类型
     */
    @Override
    public void removeAll(RedisType type) {
        delete(type.getKeyName());
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 向Redis中添加一条永久记录
     *
     * @param key   key
     * @param value value
     */
    @Override
    public void put(String key, String value) {
        this.stringRedisTemplate.opsForValue().set(key, value);
    }

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
    @Override
    public void put(String key, String value, long expiredTime, TimeUnit unit) {
        this.stringRedisTemplate.opsForValue().set(key, value, expiredTime, unit);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据可以获取value
     *
     * @param key key
     */
    @Override
    public String get(String key) {
        checkKey(key);
        return this.stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据key删除redis中的记录
     *
     * @param key key
     */
    @Override
    public void delete(String key) {
        this.stringRedisTemplate.delete(key);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 检查key是否为空
     *
     * @param key key
     */
    private void checkKey(String key) {
        if (null == key || key.length() == 0) {
            throw new ServiceException(ExceptionEnum.REDIS_KEY_NULL_POINTER_ERROR);
        }
    }
}
