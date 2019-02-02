package com.sky.lli.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.PageParam
 * VERSION:   1.0
 * Created by lihao
 * DATE: 2018/5/31
 */
@Data
public class PageParam<T> implements Serializable {

    //页码
    private Integer pageNum;
    //条数
    private Integer pageSize;
    //参数
    private T data;
}
