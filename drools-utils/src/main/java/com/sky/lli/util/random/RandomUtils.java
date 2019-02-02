package com.sky.lli.util.random;

import java.io.Serializable;
import java.util.Random;

/**
 * 随机数、随即字符串工具
 */
public class RandomUtils implements Serializable {

    private RandomUtils() {
    }

    private static final char[] allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ".toCharArray();
    private static final char[] letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] numberChar = "0123456789".toCharArray();

    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateDefaultString(int length) {
        return generateRandomString(allChar, length);
    }

    /**
     * 返回一个定长的随机纯字母字符串(只包含大小写字母)
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateLetterString(int length) {
        return generateRandomString(letterChar, length);
    }

    /**
     * 返回一个定长的随机字符串(只包含数字)
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateNumberString(int length) {
        return generateRandomString(numberChar, length);
    }

    /**
     * Date 2018/1/16
     * Author lihao [lihao@sinosoft.com.cn]
     * 方法说明: 生成随机字符串
     *
     * @param array  取值范围
     * @param length 长度
     */
    private static String generateRandomString(char[] array, int length) {
        if (array == null || array.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(array[random.nextInt(array.length)]);
        }
        return sb.toString();
    }


    /**
     * 返回一个定长的随机纯大写字母字符串(只包含大小写字母)
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateLowerString(int length) {
        return generateLetterString(length).toLowerCase();
    }

    /**
     * 返回一个定长的随机纯小写字母字符串(只包含大小写字母)
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateUpperString(int length) {
        return generateLetterString(length).toUpperCase();
    }

}
