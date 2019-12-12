package com.shenxiangwei.springbootjwttoken.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * <br>
 * 标题: <br>
 * 描述: <br>
 *
 * @author shenxiangwei
 * @time 2019/11/1 11:32 上午
 */
public class TokenExpiredException extends AuthenticationException {
    private static final long serialVersionUID = -337122744390438939L;

    public TokenExpiredException(String msg, Throwable t) {
        super(msg, t);
    }

    public TokenExpiredException(String msg) {
        super(msg);
    }
}
