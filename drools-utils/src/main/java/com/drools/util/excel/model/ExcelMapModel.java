package com.drools.util.excel.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 描述： excel 导出（mybatis查询 List<LinkedHashMap<String, Object>>）
 * CLASSPATH: com.drools.util.excel.ExcelMapModel
 * VERSION:   1.0
 * Created by gaowei
 * DATE:      2017/8/28
 */
public class ExcelMapModel implements Serializable {

    /**
     * 工作表的名称
     */
    private String sheetName;

    /**
     * 列的表头的二维数组,对应mapList 数据
     * 例如: String[][]  headers={{"NAME","名称"},{"ACCOUNT","账号"},{"TRANAMT","金额"},{"REPORTDATE","统计日期"}};
     */
    private String[][] headers;

    /**
     * 往Excel中写入的数据集合
     */
    private List<Map<String, Object>> mapList;
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

    public String[][] getHeaders() {
        return headers;
    }

    public void setHeaders(String[][] headers) {
        this.headers = headers;
    }

    public List<Map<String, Object>> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map<String, Object>> mapList) {
        this.mapList = mapList;
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


