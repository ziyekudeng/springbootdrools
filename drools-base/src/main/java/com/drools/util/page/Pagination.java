package com.drools.util.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.drools.cpyy.util.page.Pagination
 * VERSION:   1.0
 * Created by gaowei
 * DATE:      2017/9/29
 */
@Data
@SuppressWarnings({"rawtypes", "unchecked"})
public class Pagination<T> implements Serializable {

    //当前页
    private Integer pageNum;
    //每页的数量
    private Integer pageSize;
    //总记录数
    private Integer total;
    //总页数
    private Integer pages;
    //结果集
    private List<T> list;

    public Pagination() {
    }

    /**
     * Date 2017/9/29
     * Author gaowei
     * <p>
     * 方法说明: 没有分页的集合
     *
     * @param list 集合
     */
    public Pagination(List<T> list) {
        this.list = list;
    }


    /**
     * Date 2017/9/29
     * Author gaowei
     * <p>
     * 方法说明: 有分页的集合
     *
     * @param pageNum  当前页
     * @param pageSize 每页的数量
     * @param total    总数
     * @param list     集合
     */
    public Pagination(Integer pageNum, Integer pageSize, Integer total, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
        //设置总页数
        this.pages = getPages(pageSize, total);
    }

    /**
     * Date 2017/9/29
     * Author gaowei
     * <p>
     * 方法说明: 设置总页数
     *
     * @param pageSize 每页的数量
     * @param total    总数
     */
    private Integer getPages(Integer pageSize, Integer total) {

        if (total == -1) {
            return 1;
        }
        if (pageSize > 0) {
            return (total / pageSize + ((total % pageSize == 0) ? 0 : 1));
        }
        return 0;
    }
}
