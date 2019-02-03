package com.drools.util.excel.impl;

import com.drools.util.StringUtil;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.Serializable;
import java.util.Map;

/**
 * 描述：
 * CLASSPATH: com.sinosoft.util.excel.BaseExcelFile
 * VERSION:   1.0
 * Created by gaowei
 * DATE: 2018/1/22
 */
class BaseExcelFile implements Serializable {

    //默认开始行
    static final int DEFAULT_FIRST_ROW = 1;
    //默认开始列
    static final int DEFAULT_LAST_ROW = 1024;
    // 2003 对应最大行数(65536)
    static final int MAX_COL_SIZE = 60000;
    // Excel2003
    static final String EXCEL_2003 = ".xls";
    // Excel2007
    static final String EXCEL_2007 = ".xlsx";


    /**
     * Date 2018/1/22
     * Author gaowei
     * 方法说明: excel设置数据有效性
     *
     * @param sheet          sheet
     * @param firstRow       开始行
     * @param lastRow        结束行
     * @param firstCol       开始列
     * @param lastCol        结束列
     * @param validationData 数据有效性集合
     */
    static void setValidationData(Sheet sheet, int firstRow, int lastRow,
                                  int firstCol, int lastCol, Map<Integer, String[]> validationData) {

        //判断参数是否有效
        if (null != sheet && null != validationData && !validationData.isEmpty()) {
            //firstCol 为对应的要添加数据有效性的列
            String[] validData = validationData.get(firstCol);
            if (null != validData && validData.length > 0) {
                setValidationData(sheet, firstRow, lastRow, firstCol, lastCol, validData);
            }
        }
    }

    /**
     * 添加数据有效性检查.
     *
     * @param sheet              要添加此检查的Sheet
     * @param firstRow           开始行
     * @param lastRow            结束行
     * @param firstCol           开始列
     * @param lastCol            结束列
     * @param explicitListValues 有效性检查的下拉列表
     * @throws IllegalArgumentException 如果传入的行或者列小于0(< 0)或者结束行/列比开始行/列小
     */
    private static void setValidationData(Sheet sheet, int firstRow, int lastRow,
                                          int firstCol, int lastCol, String[] explicitListValues) {
        if (firstRow < 0 || lastRow < 0 || firstCol < 0 || lastCol < 0 || lastRow < firstRow || lastCol < firstCol) {
            throw new IllegalArgumentException("Wrong Row or Column index : " + firstRow + ":" + lastRow + ":" + firstCol + ":" + lastCol);
        }
        //2007版本
        if (sheet instanceof XSSFSheet) {
            XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper((XSSFSheet) sheet);
            XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper
                    .createExplicitListConstraint(explicitListValues);
            CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
            XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, addressList);
            validation.setSuppressDropDownArrow(true);
            validation.setShowErrorBox(true);
            sheet.addValidationData(validation);

        } else if (sheet instanceof HSSFSheet) {//2003版本

            CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
            DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(explicitListValues);
            DataValidation validation = new HSSFDataValidation(addressList, dvConstraint);
            validation.setSuppressDropDownArrow(true);
            validation.setShowErrorBox(true);
            sheet.addValidationData(validation);
        }
    }

    /**
     * Date 2018/2/2
     * Author gaowei
     * 方法说明: 设置单元格样式
     *
     * @param sheet sheet
     * @param style 样式
     */
    static void setDefaultCellStyle(Sheet sheet, CellStyle style) {
        if (null != sheet) {
            //默认设置100列
            for (int i = 0; i <= 100; i++) {
                sheet.setDefaultColumnStyle(i, style);
            }
        }
    }

    /**
     * Date 2018/2/5
     * Author gaowei
     * 方法说明: 格式化文件后缀
     *
     * @param fileName  文件名
     * @param endString 后缀
     */
    static String setFileName(String fileName, String endString) {

        if (!StringUtil.isNullOrNullValue(fileName)) {
            //判断文件名是否含有后缀
            if (fileName.toLowerCase().contains(EXCEL_2003) || fileName.contains(EXCEL_2007)) {
                return fileName.replaceAll(EXCEL_2003, endString).
                        replaceAll(EXCEL_2003.toUpperCase(), endString).
                        replaceAll(EXCEL_2007, endString).
                        replaceAll(EXCEL_2007.toUpperCase(), endString);
            } else {
                //添加后缀
                return fileName + endString;
            }
        }
        //默认返回原文件名
        return fileName;
    }
}
