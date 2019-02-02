package com.sky.lli.util.excel.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 描述：
 * CLASSPATH: com.sinosoft.util.excel.readexcel.ExcelFileInfo
 * VERSION:   1.0
 * Created by lihao
 * DATE: 2018/5/16
 */
public class ExcelFileInfo implements Serializable {
    //表头
    private List<Map<String, String>> headerList;
    //数据集合
    private List<Map<String, String>> valueList;
    //文件名
    private String fileName;
    //临时表名
    private String tempTableName;
    //创建临时表语句
    private String createTableSql;

    public List<Map<String, String>> getHeaderList() {
        return headerList;
    }

    public void setHeaderList(List<Map<String, String>> headerList) {
        this.headerList = headerList;
    }

    public List<Map<String, String>> getValueList() {
        return valueList;
    }

    public void setValueList(List<Map<String, String>> valueList) {
        this.valueList = valueList;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTempTableName() {
        return tempTableName;
    }

    public void setTempTableName(String tempTableName) {
        this.tempTableName = tempTableName;
    }

    public String getCreateTableSql() {
        return createTableSql;
    }

    public void setCreateTableSql(String createTableSql) {
        this.createTableSql = createTableSql;
    }
}
