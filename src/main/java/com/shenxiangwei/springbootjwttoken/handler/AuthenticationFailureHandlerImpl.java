package com.shenxiangwei.springbootjwttoken.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shenxiangwei.springbootjwttoken.exception.NoAuthorityException;
import com.shenxiangwei.springbootjwttoken.exception.TokenExpiredException;
import com.shenxiangwei.springbootjwttoken.exception.TokenInvalidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <br>
 * 标题: token校验失败处理类 <br>
 * 描述: <br>
 *
 * @author shenxiangwei
 * @time 2019/10/31 8:19 下午
 */
@Slf4j
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        JSONObject jsonObject = new JSONObject();
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(e instanceof TokenExpiredException){
            jsonObject.put("code", "1");
            jsonObject.put("message", "Token 过期，请重新申请 token");
            log.info("Token 过期,Fail Authentication");
        }else if(e instanceof TokenInvalidException){
            jsonObject.put("code", "1");
            jsonObject.put("message", "Token 无效，请重新申请 token");
            log.info("Token 无效,Fail Authentication");
        }else if(e instanceof NoAuthorityException){
            jsonObject.put("code", "1");
            jsonObject.put("message", "未授权");
        }else {
            jsonObject.put("code", "1");
            jsonObject.put("message", "系统异常");
        }
        String jsonString = JSON.toJSONString(jsonObject, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
        out.write(jsonString);
        out.close();
    }
}
