package com.shenxiangwei.springbootjwttoken.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * <br>
 * 标题: <br>
 * 描述: <br>
 *
 * @author shenxiangwei
 * @time 2019/11/1 7:51 下午
 */
public class NoAuthorityException extends AuthenticationException {
    private static final long serialVersionUID = 8627237726384908557L;

    public NoAuthorityException(String msg, Throwable t) {
        super(msg, t);
    }

    public NoAuthorityException(String msg) {
        super(msg);
    }
}
