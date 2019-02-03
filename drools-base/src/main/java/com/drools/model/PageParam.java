package com.drools.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述：
 * CLASSPATH: PageParam
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
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
