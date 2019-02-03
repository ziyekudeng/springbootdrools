package com.drools.exception;


/**
 * 描述： 控制层异常
 * CLASSPATH: ControllerException.java
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public class ControllerException extends EnumException {

    private static final long serialVersionUID = 1L;

    public ControllerException(IExceptionEnum responseEnum, String suffix) {
        super(responseEnum, suffix);
    }

    public ControllerException(IExceptionEnum responseEnum) {
        super(responseEnum);
    }


}
