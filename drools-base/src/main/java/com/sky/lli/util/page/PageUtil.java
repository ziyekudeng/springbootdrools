package com.sky.lli.util.page;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;

/**
 * 描述：
 * CLASSPATH: util.PageUtil
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/2/17
 */
public class PageUtil implements Serializable {

    /**
     * Date 2017/2/17
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明: 初始化分页
     */
    public static PageInfo getInitPage() {
        return getInitPage(null, null);
    }

    /**
     * Date 2017/2/17
     * Author lihao [lihao@sinosoft.com]
     * <p>
     * 方法说明:  PageInfo 初始化
     *
     * @param pageNo   分页
     * @param pageSize 条数
     */
    public static PageInfo getInitPage(Integer pageNo, Integer pageSize) {
        //创建一个新的PageInfo对象，传给后台去处理分页
        PageInfo page = new PageInfo();
        //判断页面传来page信息是否为空
        if (pageNo == null) {
            pageNo = 1;
        }
        //判断页面传来page信息是否为空
        if (pageSize == null) {
            pageSize = 10;
        }
        //设置分页
        page.setPageNum(pageNo);
        //设置条数
        page.setPageSize(pageSize);

        return page;
    }
}
