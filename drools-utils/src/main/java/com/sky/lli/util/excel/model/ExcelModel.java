package com.sky.lli.util.excel.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 描述：
 * CLASSPATH: com.sinosoft.util.excel.ExcelModel
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/8/29
 */
public class ExcelModel implements Serializable {

    /**
     * 工作表的名称
     */
    private String sheetName;
    /**
     * 列的表头的数组
     * 例如: String[] headers={"雇员唯一号","性别","用户姓名","是否","地区"};
     */
    private String[] headers;
    /**
     * 往Excel中写入的数据集合
     */
    private List<Object[]> List;
    /**
     * 单元格宽度 :
     * 例如:  int[] widths={10,12,12,12,12}
     */
    private int[] widths;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 数据有效性集合
     * key 为 下标(第几列),value 为对应的数据有效性
     * 例如:
     * 1:{"是","否"}
     * 2:{"男","女"}
     */
    private Map<Integer, String[]> validationData;


    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public java.util.List<Object[]> getList() {
        return List;
    }

    public void setList(java.util.List<Object[]> list) {
        List = list;
    }

    public int[] getWidths() {
        return widths;
    }

    public void setWidths(int[] widths) {
        this.widths = widths;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Map<Integer, String[]> getValidationData() {
        return validationData;
    }

    public void setValidationData(Map<Integer, String[]> validationData) {
        this.validationData = validationData;
    }
}
