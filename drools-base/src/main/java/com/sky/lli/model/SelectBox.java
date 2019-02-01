package com.sky.lli.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.SelectBox
 * VERSION:   1.0
 * Created by lihao
 * DATE: 2018/9/8
 */
@Data
public class SelectBox implements Serializable {

    //ID
    private Integer selectId;
    //名称
    private String selectName;
    //==============附加信息============
    //数据本身
    private Object source;
}
