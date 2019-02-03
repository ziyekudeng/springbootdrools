package com.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: BaseRuleSceneInfo
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleSceneInfo extends BaseModel {
    private Long sceneId;//主键
    private String sceneIdentify;//标识
    private Integer sceneType;//类型
    private String sceneName;//名称
    private String sceneDesc;//描述
}
