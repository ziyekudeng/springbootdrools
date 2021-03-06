package com.drools.util.pinyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;


/**
 * 描述：
 * CLASSPATH: PinyinUtil
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public class PinyinUtil implements Serializable {

    private static Logger log = LoggerFactory.getLogger(PinyinUtil.class);

    private PinyinUtil() {
    }

    //字符串正则表达式
    private static final String STRING_REGEX = "[\u4e00-\u9fa5]+";
    //数字正则表达式
    private static final String NUMBER_REGEX = "[0-9]+";
    //字母正则表达式
    private static final String LETTER_REGEX = "[a-zA-Z]+";

    /**
     * 将文字转为汉语拼音
     *
     * @param text 要转成拼音的中文
     */
    public static String toPinyin(String text) {
        char[] arrayChar = text.trim().toCharArray();
        StringBuilder hanyupinyin = new StringBuilder();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        // 输出拼音全部小写
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        // 不带声调
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        try {
            for (char cl_char : arrayChar) {
                // 如果字符是中文,则将中文转为汉语拼音
                if (String.valueOf(cl_char).matches(STRING_REGEX)) {
                    hanyupinyin.append(PinyinHelper.toHanyuPinyinStringArray(cl_char, defaultFormat)[0]);
                } else {
                    // 如果字符不是中文,则不转换
                    hanyupinyin.append(cl_char);
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            log.error("字符不能转成汉语拼音");
        }
        return hanyupinyin.toString();
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 获取首字母(大写)
     *
     * @param text 字符串
     */
    public static String getFirstLettersUp(String text) {
        return getFirstLetters(text, HanyuPinyinCaseType.UPPERCASE);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 获取首字母(小写)
     *
     * @param text 字符串
     */
    public static String getFirstLettersLo(String text) {
        return getFirstLetters(text, HanyuPinyinCaseType.LOWERCASE);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 获取首字母
     *
     * @param text     字符串
     * @param caseType 大写或小写
     */
    private static String getFirstLetters(String text, HanyuPinyinCaseType caseType) {
        char[] arrayChars = text.trim().toCharArray();
        StringBuilder hanyupinyin = new StringBuilder();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        // 输出拼音全部大小写
        defaultFormat.setCaseType(caseType);
        // 不带声调
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        try {
            for (char cl_char : arrayChars) {
                String str = String.valueOf(cl_char);
                // 如果字符是中文,则将中文转为汉语拼音,并取第一个字母
                if (str.matches(STRING_REGEX)) {
                    hanyupinyin.append(PinyinHelper.toHanyuPinyinStringArray(cl_char, defaultFormat)[0].substring(0, 1));
                } else if (str.matches(NUMBER_REGEX)) {
                    // 如果字符是数字,取数字
                    hanyupinyin.append(cl_char);
                } else if (str.matches(LETTER_REGEX)) {
                    // 如果字符是字母,取字母
                    hanyupinyin.append(cl_char);
                } else {
                    //不处理(比如:标点符号等)
                    hanyupinyin.append(cl_char);
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            log.error("字符不能转成汉语拼音");
        }
        return hanyupinyin.toString();
    }

}
