package com.shenxiangwei.springbootjwttoken.filter;

import com.shenxiangwei.redisplugin.cache.RedisClient;
import com.shenxiangwei.springbootjwttoken.exception.NoAuthorityException;
import com.shenxiangwei.springbootjwttoken.exception.TokenExpiredException;
import com.shenxiangwei.springbootjwttoken.exception.TokenInvalidException;
import com.shenxiangwei.springbootjwttoken.filter.entity.UserInfo;
import com.shenxiangwei.springbootjwttoken.service.SelectUserInfoWebService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    private SelectUserInfoWebService selectUserInfoWebService;



    private RedisClient redisClient;

    public void setRedisClient(RedisClient redisClient) {
        this.redisClient = redisClient;
    }

    public void setSelectUserInfoWebService(SelectUserInfoWebService selectUserInfoWebService) {
        this.selectUserInfoWebService = selectUserInfoWebService;
    }

    public JwtAuthenticationTokenFilter() {
        super("/auth/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {


        String token = httpServletRequest.getHeader("token");
        if(null == token){
            throw new NoAuthorityException("未授权");
        }
        Map<String, Object> resultMap = Jwt.validToken(token);
        TokenState state = TokenState.getTokenState((String) resultMap.get("state"));
        switch (state) {
            case VALID:

                /**
                 * 判断次token是否被更新过(Redis get userId 得到 Redis缓存的 token,如果和当前你的token值一样,则正常),
                 * 更新过则抛异常,没更新过,则在Redis set( userId--->token )
                 */
                net.minidev.json.JSONObject data = (net.minidev.json.JSONObject) resultMap.get("data");
                String userId = String.valueOf(data.get("userId"));

                if(null == redisClient.get("token"+userId)){
                    throw new TokenExpiredException("token过期");
                }else if(!token.equals(String.valueOf(redisClient.get("token"+userId)))){
                    throw new TokenExpiredException("token过期");
                }
                UserInfo userInfo = new UserInfo();
                userInfo = selectUserInfoWebService.selectUserInfo(Long.valueOf(userId));

                return new UsernamePasswordAuthenticationToken(userInfo, userInfo.getPassword(), userInfo.getAuthorities());
            case EXPIRED:
                throw new TokenExpiredException("token过期");
            default:
                throw new TokenInvalidException("token非法");
        }

    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request,response,failed);
    }
}
