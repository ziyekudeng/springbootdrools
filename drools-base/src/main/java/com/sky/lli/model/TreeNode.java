package com.sky.lli.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.lli.model.TreeNode
 * VERSION:   1.0
 * Created by lihao
 * DATE: 2018/6/5
 */
@Data
public class TreeNode implements Serializable {

    //主键
    private Integer nodeId;
    //名称
    private String nodeName;
    //父级ID
    private Integer parentId;
    //子集
    private List<TreeNode> childList;

    //==============附加信息============
    //数据本身
    private Object source;

}
