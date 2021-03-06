package com.drools.config.kaptcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 描述：图片验证码
 * CLASSPATH: com.drools.util.kaptcha.KaptchaConfig
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
@Configuration
public class KaptchaConfig {


    /*
     * 配置文件详解:
     * #	kaptcha.border  是否有边框  默认为true  我们可以自己设置yes，no
     * #	kaptcha.border.color   边框颜色   默认为Color.BLACK
     * #	kaptcha.border.thickness  边框粗细度  默认为1
     * #	kaptcha.producer.impl   验证码生成器  默认为DefaultKaptcha
     * #	kaptcha.textproducer.impl   验证码文本生成器  默认为DefaultTextCreator
     * #	kaptcha.textproducer.char.string   验证码文本字符内容范围  默认为abcde2345678gfynmnpwx
     * #	kaptcha.textproducer.char.length   验证码文本字符长度  默认为5
     * #	kaptcha.textproducer.font.names    验证码文本字体样式  默认为new Font("Arial", 1, fontSize), new Font("Courier", 1, fontSize)
     * #	kaptcha.textproducer.font.size   验证码文本字符大小  默认为40
     * #	kaptcha.textproducer.font.color  验证码文本字符颜色  默认为Color.BLACK
     * #	kaptcha.textproducer.char.space  验证码文本字符间距  默认为2
     * #	kaptcha.noise.impl    验证码噪点生成对象  默认为DefaultNoise
     * #	kaptcha.noise.color   验证码噪点颜色   默认为Color.BLACK
     * #	kaptcha.obscurificator.impl   验证码样式引擎  默认为WaterRipple
     * #	kaptcha.word.impl   验证码文本字符渲染   默认为DefaultWordRenderer
     * #	kaptcha.background.impl   验证码背景生成器   默认为DefaultBackground
     * #	kaptcha.background.clear.from   验证码背景颜色渐进   默认为Color.LIGHT_GRAY
     * #	kaptcha.background.clear.to   验证码背景颜色渐进   默认为Color.WHITE
     * #	kaptcha.image.width   验证码图片宽度  默认为200
     * #	kaptcha.image.height  验证码图片高度  默认为50
     */

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 图片验证码,包含字母
     */
    @Bean(name = "randomImg")
    public DefaultKaptcha randomImgKaptcha() {
        //取值范围
        String charString = "0123456789ABCDEFGHIJKLMNPQRSTUVWXYZ";
        return getDefaultKaptcha(charString);
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 图片验证码,纯数字
     */
    @Bean(name = "randomNum")
    public DefaultKaptcha randomNumKaptcha() {
        //取值范围
        String charString = "0123456789";
        return getDefaultKaptcha(charString);
    }


    /**
     * DATE:
     * Author gaowei
     * 方法说明: DefaultKaptcha 实例
     *
     * @param charString 取值范围
     */
    private DefaultKaptcha getDefaultKaptcha(String charString) {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "yes");
        properties.setProperty("kaptcha.border.color", "105,179,90");
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        properties.setProperty("kaptcha.image.width", "200");
        properties.setProperty("kaptcha.image.height", "60");
        properties.setProperty("kaptcha.textproducer.font.size", "45");
        properties.setProperty("kaptcha.textproducer.char.string", charString);
        properties.setProperty("kaptcha.textproducer.char.length", "6");
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }
}
