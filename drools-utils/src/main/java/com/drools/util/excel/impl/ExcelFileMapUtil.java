package com.drools.util.excel.impl;

import com.drools.util.CollectionUtil;
import com.drools.util.StringUtil;
import com.drools.util.excel.model.ExcelMapModel;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.BeanUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述： 生成excel
 * CLASSPATH: com.drools.util.excel.ExcelFileMapUtil
 * VERSION:   1.0
 * Created by gaowei
 * DATE:      2017/8/28
 */
public class ExcelFileMapUtil extends BaseExcelFile implements Serializable {

    /**
     * Date 2017/2/20
     * Author gaowei
     * <p>
     * 方法说明: 生成一个是否包含字典值, 翻译, 日期的sheet页的Excel
     *
     * @param fileMod 封装了所有参数
     * @param path    文件存放的目录路径
     * @return 返回文件名 mes
     * throws Exception
     */
    public static String downloadExcelFile2003Util(ExcelMapModel fileMod, String path) throws IOException {
        String mes = "";
        //判断参数是否为空
        if (null != fileMod) {

            //对数据进行验证和处理
            List<ExcelMapModel> modeList = checkOrSplitList(fileMod);

            //调用生成多个sheet页的方法
            mes = downBatchExcelFile2003Util(modeList, path, fileMod.getFileName());
        }
        return mes;
    }

    /**
     * Date 2017/2/21
     * Author gaowei
     * <p>
     * 方法说明: 对数据集合进行分割处理，防止 EXCEL 2003 超过 65536行数据
     *
     * @param excelMapModel 数据对象
     * @return 新的 ExcelMapModel 集合
     */
    private static List<ExcelMapModel> checkOrSplitList(ExcelMapModel excelMapModel) {

        //存放分割后的model集合
        List<ExcelMapModel> modeList = new ArrayList<>();

        //excel2003版本一个工作表最多可有65536行
        if (excelMapModel.getMapList().size() > MAX_COL_SIZE) {
            //分割数据集合
            List<List<Map<String, Object>>> resultList = splitList(excelMapModel.getMapList(), MAX_COL_SIZE);
            //循环创建新的 ExcelMapModel
            for (int i = 0; i < resultList.size(); i++) {
                //创建新的 ExcelMapModel
                ExcelMapModel newExcelMapModel = new ExcelMapModel();
                //复制 ExcelMapModel 里的其他信息
                BeanUtils.copyProperties(excelMapModel, newExcelMapModel, "mapList");
                //设置新的list集合
                newExcelMapModel.setMapList(resultList.get(i));
                //设置新的sheet名称(默认 原名称拼接当前循环下表 例如：原sheet名称；测试  新名称：测试_1 )
                newExcelMapModel.setSheetName(excelMapModel.getSheetName() + "_" + i);

                //将新的 ExcelMapModel 添加到新的集合里
                modeList.add(newExcelMapModel);
            }
        } else {
            modeList.add(excelMapModel);
        }

        return modeList;
    }

    /**
     * Date 2018/1/22
     * Author gaowei
     * 方法说明: 生成包含多个sheet页的Excel
     *
     * @param fileMods fileMods集合
     * @param path     文件存放路径
     */
    public static String downBatchExcelFile2003Util(List<ExcelMapModel> fileMods, String path) throws IOException {
        return downBatchExcelFile2003Util(fileMods, path, null);
    }

    /**
     * Date 2017/2/20
     * Author gaowei
     * <p>
     * 方法说明: 生成包含多个sheet页的Excel
     *
     * @param fileMods fileMods集合
     * @param path     文件存放路径
     * @param fileName 文件名称
     * @return 返回Excel文件名 fileTempName
     * throws Exception
     */
    public static String downBatchExcelFile2003Util(List<ExcelMapModel> fileMods, String path, String fileName) throws IOException {
        // 文件路径
        String filePath = path + File.separatorChar + System.currentTimeMillis() + File.separatorChar;
        // 文件名字
        String fileTempName = filePath + System.currentTimeMillis() + EXCEL_2003;
        if (!StringUtil.isNullOrNullValue(fileName)) {
            fileName = setFileName(fileName, EXCEL_2003);
            fileTempName = filePath + fileName;
        }

        try (HSSFWorkbook workbook = new HSSFWorkbook()) {

            File file = new File(filePath);
            // 如果目录不存在就创建
            if (!(file.exists() && file.isDirectory())) {
                boolean mkdirs = file.mkdirs();
                if (!mkdirs) {
                    throw new NullPointerException("文件夹不存在或创建失败！");
                }
            }

            //判断集合fileMods是否为空,返回true,非空,返回false 空
            if (!CollectionUtil.collectionIsNull(fileMods)) {
                //判断集合list为空时不生成Excel,抛出异常,否则生成Excel,返回mes=文件名
                for (int k = 0; k < fileMods.size(); k++) {
                    //获取对象ExcelMapModel
                    ExcelMapModel excelMapModel = fileMods.get(k);
                    //检查当前对象里的数据是否超过 EXCEL 2003 最大行数,如果超过，进行分割
                    List<ExcelMapModel> modeList = checkOrSplitList(excelMapModel);
                    //循环ExcelMapModel
                    for (ExcelMapModel fileMod : modeList) {
                        //创建excel
                        createExcel2003(workbook, k, fileMod);
                    }
                }

                //写入输出流
                FileOutputStream os = new FileOutputStream(fileTempName);
                workbook.write(os);

                os.flush();
                os.close();
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

        return fileTempName;
    }

    /**
     * Date 2017/8/29
     * Author gaowei
     * <p>
     * 方法说明:  创建excel2003
     *
     * @param workbook workbook
     * @param index    索引
     * @param fileMod  excel信息
     */
    private static void createExcel2003(HSSFWorkbook workbook, int index, ExcelMapModel fileMod) {
        //获取表头信息
        String[][] heades = fileMod.getHeaders();
        //判断表头集合是否为空
        if (null != fileMod.getHeaders()) {
            //表名默认为 “sheet”+下表
            String sheetName = null == fileMod.getSheetName() ? "sheet" + index : fileMod.getSheetName();
            // 添加工作表
            HSSFSheet sheet = workbook.createSheet(sheetName);
            // 生成列标题样式
            HSSFCellStyle style = workbook.createCellStyle();
            //设置样式
            createCellStyle(style);
            //生成excel内容格式  (防止科学技术法)
            HSSFCellStyle textStytle = workbook.createCellStyle();
            HSSFDataFormat format = workbook.createDataFormat();
            textStytle.setDataFormat(format.getFormat("@"));

            // 创建表格标题行
            HSSFRow row = sheet.createRow(0);
            //获取单元格size
            int colSize = fileMod.getHeaders().length;
            //创建表头
            if (colSize > 0) {
                // 循环列数(标题)
                for (int i = 0; i < colSize; i++) {
                    //创建列
                    HSSFCell cell = row.createCell(i);
                    //表头
                    String colName = heades[i][1];
                    //创建列
                    createCell(style, cell, colName);
                    //设置单元格宽度
                    sheet.setColumnWidth(i, (null != fileMod.getWidths() && fileMod.getWidths().length > i ? fileMod.getWidths()[i] : 30) * 256);

                    //设置数据有效性
                    setValidationData(sheet, DEFAULT_FIRST_ROW, DEFAULT_LAST_ROW, i, i, fileMod.getValidationData());
                }
            }
            //写入数据
            createRowValue(fileMod, sheet, textStytle);
        }
    }

    /**
     * Date 2018/2/8
     * Author gaowei
     * 方法说明: 写入数据
     *
     * @param fileMod    excel
     * @param sheet      sheet
     * @param textStytle 样式
     */
    private static void createRowValue(ExcelMapModel fileMod, HSSFSheet sheet, HSSFCellStyle textStytle) {
        //判断有没有需要写入的数据
        if (!CollectionUtil.collectionIsNull(fileMod.getMapList())) {
            //创建excel行和内容
            createRow(fileMod, sheet, textStytle);
        } else {
            setDefaultCellStyle(sheet, textStytle);
        }
    }

    /**
     * Date 2017/8/29
     * Author gaowei
     * <p>
     * 方法说明:  创建excel行和内容
     *
     * @param fileMod    excel实体信息
     * @param sheet      sheet
     * @param textStytle 样式
     */
    private static void createRow(ExcelMapModel fileMod, HSSFSheet sheet, HSSFCellStyle textStytle) {

        HSSFRow row;
        //获取数据总量
        int totalSize = fileMod.getMapList().size();
        //表头信息
        String[][] heades = fileMod.getHeaders();
        //获取单元格size
        int colSize = heades.length;
        //获取数据
        Map<String, Object> obj;
        //往Excel中写入数据
        for (int j = 0; j < totalSize; j++) {
            //获取数据
            obj = fileMod.getMapList().get(j);
            //创建行
            row = sheet.createRow(j + 1);

            //循环单元格，写入excel
            for (int n = 0; n < colSize; n++) {
                //获取单元格数据
                String value = null != obj.get(heades[n][0]) ? obj.get(heades[n][0]).toString() : "";
                //创建第j个单元格
                HSSFCell cell = row.createCell(n);
                if (!cell.getCellTypeEnum().equals(CellType.STRING)) {
                    cell.setCellType(CellType.STRING);
                }
                //设置样式
                cell.setCellStyle(textStytle);
                cell.setCellValue(value);
                cell.setCellType(CellType.STRING);
            }
        }
    }

    /**
     * Date 2017/8/29
     * Author gaowei
     * <p>
     * 方法说明:  创建列表头
     *
     * @param style   样式
     * @param cell    列
     * @param colName 表头名称
     */
    private static void createCell(HSSFCellStyle style, HSSFCell cell, String colName) {
        //默认字符串
        if (!cell.getCellTypeEnum().equals(CellType.STRING)) {
            cell.setCellType(CellType.STRING);
        }
        cell.setCellStyle(style);
        HSSFRichTextString text = new HSSFRichTextString(colName);
        cell.setCellValue(text);
        cell.setCellType(CellType.STRING);
    }

    /**
     * Date 2017/8/29
     * Author gaowei
     * <p>
     * 方法说明:  初始化样式
     *
     * @param style 样式
     */
    private static void createCellStyle(HSSFCellStyle style) {
        // 设置这些样式
        style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
    }

    /**
     * Date 2017/2/20
     * Author gaowei
     * <p>
     * 方法说明: 生成一个是否包含字典值, 翻译, 日期的sheet页的Excel
     *
     * @param fileMod 封装了所有参数
     * @param path    文件存放的目录路径
     * @return 返回文件名 mes
     * throws Exception
     */
    public static String downloadExcelFile2007Util(ExcelMapModel fileMod, String path) throws IOException {

        String mes = "";

        if (null != fileMod) {

            List<ExcelMapModel> modeList = new ArrayList<>();
            modeList.add(fileMod);

            //调用生成多个sheet页的方法
            mes = downBatchExcelFile2007Util(modeList, path, fileMod.getFileName());
        }

        return mes;

    }

    /**
     * Date 2017/2/21
     * Author gaowei
     * <p>
     * 方法说明:将现有的List按照指定的大小(size)分成多段新的List
     *
     * @param toList   待分割的list集合
     * @param pageSize 每段list的大小
     * @param <T>      泛型
     * @return 返回新list集合
     */
    private static <T> List<List<T>> splitList(List<T> toList, int pageSize) {

        //list的大小
        int listSize = toList.size();
        //创建一个新的list 复制参数里的list，以确保操作 此集合不影响原来的数据
        //list复制
        List<T> list = new ArrayList<>(toList);
        //根据指定大小计算 总的list需要分几段指定的list
        int page = (listSize + (pageSize - 1)) / pageSize;
        //创建list数组 ,用来保存分割后的list
        List<List<T>> listArray = new ArrayList<>();
        //按照计算出来的 段数 遍历
        for (int i = 0; i < page; i++) {
            //数组每一位放入一个分割后的list
            List<T> subList;
            //开始索引
            int startSize = pageSize * i;
            //结束索引
            int endSize = pageSize * (i + 1);

            //如果是最后一段，则结束索引等于原始集合的大小
            if (endSize >= listSize) {
                endSize = listSize;
            }
            //截取新的list集合
            subList = list.subList(startSize, endSize);

            //将分割后的list放入对应的数组的位中
            listArray.add(subList);
        }
        return listArray;
    }


    /**
     * Date 2017/2/21
     * Author gaowei
     * <p>
     * 方法说明: POI 生成包含多个sheet页的Excel
     *
     * @param fileMods 数据集合
     * @param path     文件路径
     * @return 文件名
     * throws Exception
     */
    public static String downBatchExcelFile2007Util(List<ExcelMapModel> fileMods, String path) throws IOException {
        return downBatchExcelFile2007Util(fileMods, path, null);
    }

    /**
     * Date 2017/2/21
     * Author gaowei
     * <p>
     * 方法说明: POI 生成包含多个sheet页的Excel
     *
     * @param fileMods 数据集合
     * @param path     文件路径
     * @param fileName 文件名称
     * @return 文件名
     * throws Exception
     */
    public static String downBatchExcelFile2007Util(List<ExcelMapModel> fileMods, String path, String fileName) throws IOException {

        // 文件路径
        String filePath = path + File.separatorChar + System.currentTimeMillis() + File.separatorChar;
        // 文件名字
        String fileTempName = filePath + System.currentTimeMillis() + EXCEL_2007;
        if (!StringUtil.isNullOrNullValue(fileName)) {
            fileName = setFileName(fileName, EXCEL_2007);
            fileTempName = filePath + fileName;
        }

        try (XSSFWorkbook workbook = new XSSFWorkbook()) {

            File file = new File(filePath);
            // 如果目录不存在就创建
            if (!(file.exists() && file.isDirectory())) {
                boolean mkdirs = file.mkdirs();
                if (!mkdirs) {
                    throw new NullPointerException("文件夹不存在或创建失败！");
                }
            }

            //判断集合fileMods是否为空,返回true,非空,返回false 空
            if (!CollectionUtil.collectionIsNull(fileMods)) {

                //判断集合list为空时不生成Excel,抛出异常,否则生成Excel,返回mes=文件名
                for (int k = 0; k < fileMods.size(); k++) {
                    //获取对象ExcelMapModel
                    ExcelMapModel fileMod = fileMods.get(k);
                    //判断fileMod.getList()集合是否为空
                    if (null != fileMod.getHeaders()) {
                        //创建excel信息
                        createExcel(workbook, k, fileMod);
                    } else {
                        throw new NullPointerException("传入的参数ExcelMapModel对象中的集合属性为空，参数传入错误，不能生成Excel！");
                    }
                }

                //写入输出流
                FileOutputStream os = new FileOutputStream(fileTempName);
                workbook.write(os);
                //关闭
                os.flush();
                os.close();
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

        //返回文件名
        return fileTempName;
    }

    /**
     * Date 2017/8/29
     * Author gaowei
     * <p>
     * 方法说明:  创建excel信息
     *
     * @param workbook excel
     * @param index    索引
     * @param fileMod  excel实体信息
     */
    private static void createExcel(XSSFWorkbook workbook, int index, ExcelMapModel fileMod) {
        //表名默认为 “sheet”+下表
        String sheetName = null == fileMod.getSheetName() ? "sheet" + index : fileMod.getSheetName();
        // 添加工作表
        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 生成列标题样式
        XSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        //生成excel内容格式  (防止科学技术法)
        XSSFCellStyle textStytle = workbook.createCellStyle();
        XSSFDataFormat format = workbook.createDataFormat();
        textStytle.setDataFormat(format.getFormat("@"));
        //创建行
        createRow(fileMod, sheet, style, textStytle);


    }

    /**
     * Date 2017/8/29
     * Author gaowei
     * <p>
     * 方法说明:  创建excel内容信息
     *
     * @param fileMod    excel实体
     * @param sheet      sheet
     * @param style      样式
     * @param textStytle 内容样式
     */
    private static void createRow(ExcelMapModel fileMod, XSSFSheet sheet, XSSFCellStyle style, XSSFCellStyle textStytle) {
        // 创建表格标题行
        XSSFRow row = sheet.createRow(0);
        //获取单元格size
        int colSize = fileMod.getHeaders().length;
        //获取表头信息
        String[][] headers = fileMod.getHeaders();
        if (null != headers && headers.length > 0) {
            // 循环列数(标题)
            for (int i = 0; i < colSize; i++) {
                //创建列
                XSSFCell cell = row.createCell(i);
                if (!cell.getCellTypeEnum().equals(CellType.STRING)) {
                    cell.setCellType(CellType.STRING);
                }
                cell.setCellStyle(style);
                XSSFRichTextString text = new XSSFRichTextString(headers[i][1]);
                cell.setCellValue(text);
                cell.setCellType(CellType.STRING);

                //设置单元格宽度
                sheet.setColumnWidth(i, (null != fileMod.getWidths() && fileMod.getWidths().length > i ? fileMod.getWidths()[i] : 30) * 256);
                //设置数据有效性
                setValidationData(sheet, DEFAULT_FIRST_ROW, DEFAULT_LAST_ROW, i, i, fileMod.getValidationData());

            }
            //写入数据
            createRowValue(fileMod, sheet, textStytle, colSize, headers);
        }


    }

    /**
     * Date 2018/2/8
     * Author gaowei
     * 方法说明: 写入数据
     *
     * @param fileMod    excel
     * @param sheet      sheet
     * @param textStytle 样式
     * @param colSize    列
     * @param headers    表头
     */
    private static void createRowValue(ExcelMapModel fileMod, XSSFSheet sheet, XSSFCellStyle textStytle, int colSize, String[][] headers) {
        XSSFRow row;
        //判断是否有需要写入的数据
        if (!CollectionUtil.collectionIsNull(fileMod.getMapList())) {
            //获取数据总量
            int totalSize = fileMod.getMapList().size();
            //获取数据
            Map<String, Object> obj;
            //往Excel中写入数据
            for (int j = 0; j < totalSize; j++) {
                //获取数据
                obj = fileMod.getMapList().get(j);
                //创建行
                row = sheet.createRow(j + 1);
                //循环单元格，写入excel
                for (int n = 0; n < colSize; n++) {
                    //获取单元格数据
                    String value = null != obj.get(headers[n][0]) ? obj.get(headers[n][0]).toString() : "";
                    //创建第j个单元格
                    XSSFCell cell = row.createCell(n);
                    if (!cell.getCellTypeEnum().equals(CellType.STRING)) {
                        cell.setCellType(CellType.STRING);
                    }
                    //设置样式
                    cell.setCellStyle(textStytle);
                    cell.setCellValue(value);
                    cell.setCellType(CellType.STRING);
                }
            }
        } else {
            setDefaultCellStyle(sheet, textStytle);
        }
    }
}
