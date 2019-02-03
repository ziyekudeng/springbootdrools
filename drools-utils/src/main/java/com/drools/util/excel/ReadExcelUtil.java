package com.drools.util.excel;

import com.drools.util.excel.impl.ExcelReadUtil;
import com.drools.util.excel.model.ExcelFileInfo;

import java.io.File;
import java.io.Serializable;

/**
 * 描述：
 * CLASSPATH: ReadExcelUtil
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public class ReadExcelUtil implements Serializable {

    /**
     * DATE:
     * Author gaowei
     * 方法说明: POI读取Excel,默认从第一行开始读取
     *
     * @param file 文件
     */
    public static ExcelFileInfo getExcelFileInfo(File file) {
        return ExcelReadUtil.getExcelFileInfo(file, 1, 0, null);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: POI读取Excel,指定行开始读取
     *
     * @param file     文件
     * @param startRow 开始行
     */
    public static ExcelFileInfo getExcelFileInfoFromRow(File file, Integer startRow) {
        return ExcelReadUtil.getExcelFileInfo(file, startRow, 0, null);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: POI读取Excel,默认从第一行开始读取
     *
     * @param file       文件
     * @param columnSize 总列数
     */
    public static ExcelFileInfo getExcelFileInfo(File file, Integer columnSize) {
        return ExcelReadUtil.getExcelFileInfo(file, 1, 0, columnSize);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: POI读取Excel,指定行开始读取
     *
     * @param file       文件
     * @param startRow   开始行
     * @param columnSize 总列数
     */
    public static ExcelFileInfo getExcelFileInfo(File file, Integer startRow, Integer columnSize) {
        return ExcelReadUtil.getExcelFileInfo(file, startRow, 0, columnSize);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: POI读取Excel,指定行,指定列开始读取
     *
     * @param file      文件
     * @param startRow  开始行
     * @param startCell 指定列
     */
    public static ExcelFileInfo getExcelFileFromRowCell(File file, Integer startRow, Integer startCell) {
        return ExcelReadUtil.getExcelFileInfo(file, startRow, startCell, null);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: POI读取Excel,指定行,指定列开始读取
     *
     * @param file       文件
     * @param startRow   开始行
     * @param startCell  指定列
     * @param columnSize 总列数
     */
    public static ExcelFileInfo getExcelFileInfo(File file, Integer startRow, Integer startCell, Integer columnSize) {
        return ExcelReadUtil.getExcelFileInfo(file, startRow, startCell, columnSize);
    }
}
