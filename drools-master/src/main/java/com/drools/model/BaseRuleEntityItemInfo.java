package com.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: BaseRuleEntityItemInfo
 * VERSION:   1.0
 * Created by gaowei
 * DATE:      2017/7/20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleEntityItemInfo extends BaseModel {
    private Long itemId;//主键
    private Long entityId;//实体id
    private String itemName;//字段名称
    private String itemIdentify;//字段标识
    private String itemDesc;//属性描述
}
