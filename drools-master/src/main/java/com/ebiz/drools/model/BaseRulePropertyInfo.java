package com.ebiz.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: BaseRulePropertyInfo
 * VERSION:   1.0
 * Created by gaowei
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRulePropertyInfo extends BaseModel{
    private Long rulePropertyId;//主键
    private String rulePropertyIdentify;//标识
    private String rulePropertyName;//名称
    private String rulePropertyDesc;//描述
    private String defaultValue;//默认值
}
