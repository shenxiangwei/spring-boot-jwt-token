package com.shenxiangwei.springbootjwttoken.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * <br>
 * 标题: <br>
 * 描述: <br>
 *
 * @author shenxiangwei
 * @time 2019/11/1 7:28 下午
 */
public class TokenInvalidException extends AuthenticationException {
    private static final long serialVersionUID = 5972367462275515728L;

    public TokenInvalidException(String msg, Throwable t) {
        super(msg, t);
    }

    public TokenInvalidException(String msg) {
        super(msg);
    }
}
