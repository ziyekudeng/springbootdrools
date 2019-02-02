package com.ebiz.drools.model.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RedisType {

    /**
     * 缓存标识: 登录信息缓存
     */
    REDIS_LOGIN_KEY("REDIS_LOGIN_KEY"),
    /**
     * 缓存标识: 数据字典信息缓存
     */
    REDIS_DICT_KEY("REDIS_DICT_KEY");

    private String keyName;
}
