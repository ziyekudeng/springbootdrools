package com.drools.util.excel.impl;

import com.drools.util.CollectionUtil;
import com.drools.util.excel.model.ExcelFileInfo;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 * CLASSPATH: com.sinosoft.util.excel.readexcel.ExcelReadUtil
 * VERSION:   1.0
 * Created by gaowei
 * DATE: 2018/5/16
 */
public class ExcelReadUtil implements Serializable {
    /*
     * POI读取Excel信息并封装Excel相关信息
     * 1.表头
     * 2.数据
     * 3.建表语句
     */

    private ExcelReadUtil() {
    }


    /**
     * Date 2018/5/16
     * Author gaowei
     * 方法说明: POI读取Excel,获取表头,数据等相关信息
     *
     * @param file       文件
     * @param startRow   开始行
     * @param startCell  开始列
     * @param columnSize 总行数
     */
    public static ExcelFileInfo getExcelFileInfo(File file, Integer startRow, Integer startCell, Integer columnSize) {
        ExcelFileInfo excelFileInfo = new ExcelFileInfo();
        if (null == file) {
            return null;
        }
        //文件名
        excelFileInfo.setFileName(file.getName());
        //读取excel
        readExcel(file, startRow, startCell, columnSize, excelFileInfo);

        return excelFileInfo;
    }

    /**
     * Date 2018/5/16
     * Author gaowei
     * 方法说明: 读取Excel,封装数据
     *
     * @param file          文件
     * @param startRow      开始行
     * @param startCell     开始列
     * @param columnSize    总列数
     * @param excelFileInfo excel信息
     */
    private static void readExcel(File file, Integer startRow, Integer startCell, Integer columnSize, ExcelFileInfo excelFileInfo) {
        /*
         * 读取规则:
         *      1.如果指定了读取行数和总的列数,则根据列数和行数读取数据
         *      2.如果指定了读取行数,没有指定总的列数,则总的列数以指定行数对应的列数为准
         *      3.如果没有指定行数,有指定总列数,则默认从第一行(Excel下标从0开始)根据总的列数读取读取
         *      4.如果没有指定行数,没有指定总列数,则默认从第一行(Excel下标从0开始)以及对应的列数开始读取
         */

        //=======================暂时先处理 2007以后版本的Excel,2003后期维护
        //默认从第一行开始
        if (null == startRow || startRow == 0) {
            startRow = 1;
        }
        try (InputStream inputStream = new FileInputStream(file);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            //获取第一个 sheet
            XSSFSheet sheet = workbook.getSheetAt(0);

            if (null == columnSize || columnSize == 0) {
                //第一行总列数
                int firstRowLastCellNum = (int) sheet.getRow(0).getLastCellNum();
                //指定行总列数
                int startRowLastCellNum = (int) sheet.getRow(startRow).getLastCellNum();
                //取最大者
                columnSize = (startRowLastCellNum < firstRowLastCellNum ? firstRowLastCellNum : startRowLastCellNum);
            }
            //获取表头数据
            getHeader(sheet, startRow, columnSize, excelFileInfo);
            //建表语句(默认临时表名:EX_TABLE_+时间戳)
            getCreateTableSqlByColumnSize(columnSize, excelFileInfo);
            //获取数据
            getExcelData(sheet, startRow, startCell, columnSize, excelFileInfo);

        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    /**
     * Date 2018/5/16
     * Author gaowei
     * 方法说明: 获取excel数据
     *
     * @param sheet         sheet
     * @param startRow      开始行
     * @param startCell     开始列
     * @param columnSize    总列数
     * @param excelFileInfo excel信息
     */
    private static void getExcelData(XSSFSheet sheet, Integer startRow, Integer startCell, Integer columnSize, ExcelFileInfo excelFileInfo) {

        if (CollectionUtil.collectionIsNull(excelFileInfo.getValueList())) {
            excelFileInfo.setValueList(new ArrayList<>());
        }
        //获取总行数
        int totalRow = sheet.getLastRowNum();
        if (totalRow > 0) {
            //判断指定列
            if (null == startCell) {
                startCell = 0;
            }
            //循环获取数据
            for (int i = 0; i < totalRow; i++) {
                Map<String, String> valueMap = new HashMap<>();
                //从指定行开始
                XSSFRow row = sheet.getRow(i + startRow);
                for (int j = 0; j < columnSize; j++) {
                    XSSFCell cell = row.getCell(j);
                    setValue(valueMap, (j + 1 + startCell), cell);
                }
                excelFileInfo.getValueList().add(valueMap);
            }
        }
    }

    /**
     * Date 2018/5/16
     * Author gaowei
     * 方法说明: 获取表头信息
     *
     * @param sheet         sheet
     * @param startRow      开始行
     * @param columnSize    总列数
     * @param excelFileInfo excel信息
     */
    private static void getHeader(XSSFSheet sheet, Integer startRow, Integer columnSize, ExcelFileInfo excelFileInfo) {
        //指定行数之前的都是表头
        if (CollectionUtil.collectionIsNull(excelFileInfo.getHeaderList())) {
            excelFileInfo.setHeaderList(new ArrayList<>());
        }
        //循环获取表头
        for (int i = 0; i < startRow; i++) {
            XSSFRow row = sheet.getRow(i);
            Map<String, String> headerMap = new HashMap<>();
            for (int j = 0; j < columnSize; j++) {
                XSSFCell cell = row.getCell(j);
                setValue(headerMap, (j + 1), cell);
            }
            excelFileInfo.getHeaderList().add(headerMap);
        }
    }

    private static void setValue(Map<String, String> headerMap, int j, XSSFCell cell) {
        if (null != cell) {
            //设置单元格类型
            cell.setCellType(CellType.STRING);
            headerMap.put("COLUMN" + j, cell.getStringCellValue().trim());
        }
    }

    /**
     * Date 2018/5/16
     * Author gaowei
     * 方法说明: 创建临时表建表语句
     *
     * @param columnSize    列数
     * @param excelFileInfo excel信息
     */
    private static void getCreateTableSqlByColumnSize(Integer columnSize, ExcelFileInfo excelFileInfo) {
        if (null != columnSize && columnSize > 0) {
            StringBuilder sql = new StringBuilder();
            String tableName = "EX_TABLE_" + System.currentTimeMillis();
            excelFileInfo.setTempTableName(tableName);
            sql.append(" CREATE TABLE ").append(tableName).append(" ( ");
            String separator = ",";
            for (int i = 1; i <= columnSize; i++) {
                if (i == columnSize) {
                    separator = "";
                }
                sql.append(" COLUMN").append(i).append(" varchar(100) ").append("DEFAULT NULL").append(separator);
            }
            sql.append(" ) ENGINE=InnoDB DEFAULT CHARSET=utf8 ");
            excelFileInfo.setCreateTableSql(sql.toString());
        }
    }
}
