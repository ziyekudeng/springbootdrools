package com.drools.util.excel;

import com.drools.util.excel.impl.ExcelFileMapUtil;
import com.drools.util.excel.impl.ExcelFileUtil;
import com.drools.util.excel.model.ExcelMapModel;
import com.drools.util.excel.model.ExcelModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * 描述： excel 下载工具入口
 * CLASSPATH: com.drools.util.excel.DownLoadExcelUtil
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public class DownLoadExcelUtil implements Serializable {

    private static Logger log = LoggerFactory.getLogger(DownLoadExcelUtil.class);

    //region ===================================单个页签下载方法=====================================

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明:  excel 2003下载
     *
     * @param fileMod excel信息
     * @param path    文件存放的目录路径
     * @return 生成后的文件路径
     */
    public static String downloadExcel2003(ExcelMapModel fileMod, String path) {

        try {
            return ExcelFileMapUtil.downloadExcelFile2003Util(fileMod, path);
        } catch (IOException e) {
            log.error("Excel下载出错,错误信息如下:{}", e.getMessage());
        }
        return null;
    }

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明:  excel下载( 2007或更高版本)
     *
     * @param fileMod excel信息
     * @param path    文件存放的目录路径
     * @return 生成后的文件路径
     */
    public static String downloadExcel(ExcelMapModel fileMod, String path) {

        try {
            return ExcelFileMapUtil.downloadExcelFile2007Util(fileMod, path);
        } catch (IOException e) {
            log.error("Excel下载出错,错误信息如下:{}", e.getMessage());
        }
        return null;
    }

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明:  excel 2003下载
     *
     * @param fileMod excel信息
     * @param path    文件存放的目录路径
     * @return 生成后的文件路径
     */
    public static String downloadExcel2003(ExcelModel fileMod, String path) {

        try {
            return ExcelFileUtil.downloadExcelFile2003Util(fileMod, path);
        } catch (IOException e) {
            log.error("Excel下载出错,错误信息如下:{}", e.getMessage());
        }
        return null;
    }

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明:  excel下载( 2007或更高版本)
     *
     * @param fileMod excel信息
     * @param path    文件存放的目录路径
     * @return 生成后的文件路径
     */
    public static String downloadExcel(ExcelModel fileMod, String path) {

        try {
            return ExcelFileUtil.downloadExcelFile2007Util(fileMod, path);
        } catch (IOException e) {
            log.error("Excel下载出错,错误信息如下:{}", e.getMessage());
        }
        return null;
    }

    //endregion

    //region ===================================多个页签下载方法=====================================

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明:  excel 2003下载
     *
     * @param fileMods excel信息
     * @param path     文件存放的目录路径
     * @return 生成后的文件路径
     */
    public static String downloadExcel2003MultiSheet(List<ExcelMapModel> fileMods, String path) {

        try {
            return ExcelFileMapUtil.downBatchExcelFile2003Util(fileMods, path);
        } catch (IOException e) {
            log.error("Excel下载出错,错误信息如下:{}", e.getMessage());
        }
        return null;
    }

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明:  excel下载( 2007或更高版本)
     *
     * @param fileMods excel信息
     * @param path     文件存放的目录路径
     * @return 生成后的文件路径
     */
    public static String downloadExcelMultiSheet(List<ExcelMapModel> fileMods, String path) {

        try {
            return ExcelFileMapUtil.downBatchExcelFile2007Util(fileMods, path);
        } catch (IOException e) {
            log.error("Excel下载出错,错误信息如下:{}", e.getMessage());
        }
        return null;
    }

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明:  excel 2003下载
     *
     * @param fileMods excel信息
     * @param path     文件存放的目录路径
     * @return 生成后的文件路径
     */
    public static String downExcel2003MultiSheet(List<ExcelModel> fileMods, String path) {

        try {
            return ExcelFileUtil.downBatchExcelFile2003Util(fileMods, path);
        } catch (IOException e) {
            log.error("Excel下载出错,错误信息如下:{}", e.getMessage());
        }
        return null;
    }

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明:  excel下载( 2007或更高版本)
     *
     * @param fileMods excel信息
     * @param path     文件存放的目录路径
     * @return 生成后的文件路径
     */
    public static String downExcelMultiSheet(List<ExcelModel> fileMods, String path) {

        try {
            return ExcelFileUtil.downBatchExcelFile2007Util(fileMods, path);
        } catch (IOException e) {
            log.error("Excel下载出错,错误信息如下:{}", e.getMessage());
        }
        return null;
    }

    //endregion
    //region ===================================指定文件名称,多个页签下载方法=====================================

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明:  excel 2003下载
     *
     * @param fileMods excel信息
     * @param path     文件存放的目录路径
     * @return 生成后的文件路径
     */
    public static String downloadExcel2003MultiSheet(List<ExcelMapModel> fileMods, String path, String finaName) {

        try {
            return ExcelFileMapUtil.downBatchExcelFile2003Util(fileMods, path, finaName);
        } catch (IOException e) {
            log.error("Excel下载出错,错误信息如下:{}", e.getMessage());
        }
        return null;
    }

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明:  excel下载( 2007或更高版本)
     *
     * @param fileMods excel信息
     * @param path     文件存放的目录路径
     * @return 生成后的文件路径
     */
    public static String downloadExcelMultiSheet(List<ExcelMapModel> fileMods, String path, String finaName) {

        try {
            return ExcelFileMapUtil.downBatchExcelFile2007Util(fileMods, path, finaName);
        } catch (IOException e) {
            log.error("Excel下载出错,错误信息如下:{}", e.getMessage());
        }
        return null;
    }

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明:  excel 2003下载
     *
     * @param fileMods excel信息
     * @param path     文件存放的目录路径
     * @return 生成后的文件路径
     */
    public static String downExcel2003MultiSheet(List<ExcelModel> fileMods, String path, String fileName) {

        try {
            return ExcelFileUtil.downBatchExcelFile2003Util(fileMods, path, fileName);
        } catch (IOException e) {
            log.error("Excel下载出错,错误信息如下:{}", e.getMessage());
        }
        return null;
    }

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明:  excel下载( 2007或更高版本)
     *
     * @param fileMods excel信息
     * @param path     文件存放的目录路径
     * @return 生成后的文件路径
     */
    public static String downExcelMultiSheet(List<ExcelModel> fileMods, String path, String fileName) {

        try {
            return ExcelFileUtil.downBatchExcelFile2007Util(fileMods, path, fileName);
        } catch (IOException e) {
            log.error("Excel下载出错,错误信息如下:{}", e.getMessage());
        }
        return null;
    }

    //endregion
}
