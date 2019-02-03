package com.drools.util.image;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * 描述：随机数工具类
 * CLASSPATH: com.drools.util.kaptcha.RandomUtil
 * VERSION:   1.0
 * Created by gaowei
 * DATE: 2018/1/16
 */
@Slf4j
@Component
public class ImageUtils {

    private static DefaultKaptcha randomImg;

    private static DefaultKaptcha randomNum;

    @Autowired
    public ImageUtils(@Qualifier("randomImg") DefaultKaptcha randomImgBean,
                      @Qualifier("randomNum") DefaultKaptcha randomNumBean) {
        randomImg = randomImgBean;
        randomNum = randomNumBean;
    }


    /**
     * Date 2018/1/16
     * Author gaowei
     * 方法说明: 随机数字
     */
    public static String getRandomNum() {
        return randomNum.createText();
    }

    /**
     * Date 2018/1/16
     * Author gaowei
     * 方法说明: 随机字符串(数字+字母)
     */
    public static String getRandomString() {
        return randomImg.createText();
    }

    /**
     * Date 2018/1/16
     * Author gaowei
     * 方法说明: 随机字符串(大写)
     */
    public static String getUpperString() {
        return getRandomString();
    }

    /**
     * Date 2018/1/16
     * Author gaowei
     * 方法说明: 随机字符串(小写)
     */
    public static String getLowerString() {
        return getRandomString().toLowerCase();
    }

    /**
     * Date 2018/1/16
     * Author gaowei
     * 方法说明: 将字符串转换成base64编码
     *
     * @param text 字符串
     */
    public static String imgToBase64(String text) {
        return bufImageToBase64(randomImg.createImage(text));
    }

    /**
     * Date 2018/1/16
     * Author gaowei
     * 方法说明: 将字符串转换成 BufferedImage 图片
     *
     * @param text 字符串
     */
    public static BufferedImage getRandomImg(String text) {
        return randomImg.createImage(text);
    }

    /**
     * Date 2018/1/16
     * Author gaowei
     * 方法说明: 将 BufferedImage 转换成base64编码
     *
     * @param image 图片
     */
    public static String imgToBase64(BufferedImage image) {
        return bufImageToBase64(image);
    }

    /**
     * Date 2018/1/16
     * Author gaowei
     * 方法说明: 将Base64位编码的图片进行解码，并保存到指定目录
     *
     * @param base64 base64编码的图片信息
     * @param path   文件保存路径
     */
    public static String base64ToImg(String base64, String path) {
        try {
            return base64ToImg(base64, path, null);
        } catch (Exception e) {
            log.error("base64ToImg转换错误,错误信息如下:{}", e.getMessage());
        }
        return null;
    }

    /**
     * Date 2018/1/16
     * Author gaowei
     * 方法说明: 将Base64位编码的图片进行解码，并保存到指定目录
     *
     * @param base64  base64编码的图片信息
     * @param path    文件保存路径
     * @param imgName 文件名称
     */
    public static String base64ToImg(String base64, String path, String imgName) {
        // 文件路径
        String filePath = path + File.separatorChar;
        //如果文件名为空,默认当前时间戳
        if (null == imgName || imgName.trim().isEmpty()) {
            filePath += System.currentTimeMillis() + ".jpg";
        } else {
            if (imgName.endsWith(".jpg") || imgName.endsWith(".png")) {
                filePath += System.currentTimeMillis() + imgName;
            } else {
                filePath += System.currentTimeMillis() + imgName + ".jpg";
            }
        }
        // 文件名字
        try (FileOutputStream write = new FileOutputStream(filePath)) {
            byte[] decoderBytes = Base64.getDecoder().decode(base64);
            write.write(decoderBytes);
        } catch (IOException e) {
            log.error("base64ToImg转换错误,错误信息如下:{}", e.getMessage());
        }
        //返回文件保存目录
        return filePath;
    }


    /**
     * Date 2018/1/16
     * Author gaowei
     * 方法说明: 将BufferedImage转换成base64
     *
     * @param image 图片
     */
    private static String bufImageToBase64(BufferedImage image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", baos);
        } catch (IOException e) {
            log.error("imgToBase64转换错误,错误信息如下:{}", e.getMessage());
        }
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }


}
