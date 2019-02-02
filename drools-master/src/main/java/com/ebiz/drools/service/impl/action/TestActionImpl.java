package com.ebiz.drools.service.impl.action;

import com.ebiz.drools.model.fact.RuleExecutionObject;
import com.ebiz.drools.model.fact.RuleExecutionResult;
import com.ebiz.drools.model.fact.TestRule;
import com.ebiz.drools.service.DroolsActionService;
import com.ebiz.drools.util.json.JsonSerializeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 描述：
 * CLASSPATH: TestActionImpl
 * VERSION:   1.0
 * Created by gaowei
 *
 */
@Slf4j
@Service
@Transactional
public class TestActionImpl implements DroolsActionService {

    //换行符
    private static final String LINE_SEPARATOR = "line.separator";

    /**
     * Date 2017/7/24
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 引擎执行结束,实现类默认执行方法
     *
     * @param fact   参数
     * @param result 结果集
     */
    @Override
    public void execute(RuleExecutionObject fact, RuleExecutionResult result) {

        log.info(System.getProperty(LINE_SEPARATOR));
        log.info("=================================规则引擎执行结束,返回信息如下:====================================");
        //遍历map信息
        for (Map.Entry<String, Object> entry : result.getMap().entrySet()) {
            log.info(System.getProperty(LINE_SEPARATOR));
            log.info("=====key=====: " + entry.getKey() + " and value: " + entry.getValue());
        }
        TestRule t = (TestRule) fact.getFactObjectList().get(0);
        log.info("返回数据:{}", JsonSerializeUtil.toJson(t));

        log.info(System.getProperty(LINE_SEPARATOR));
        log.info("=================================规则引擎执行结束====================================");
    }
}
