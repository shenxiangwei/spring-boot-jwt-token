package com.shenxiangwei.springbootjwttoken.service;

import com.shenxiangwei.springbootjwttoken.filter.entity.UserInfo;

/**
 * <br>
 * 标题: <br>
 * 描述: <br>
 *
 * @author shenxiangwei
 * @date 2019/12/11 4:45 下午
 */
public interface SelectUserInfoWebService {
    /**
     * @param userId 用户Id
     * @return userInfo
     * @author shenxiangwei
     * @date 2019/12/11 4:50 下午 */
    UserInfo selectUserInfo(Long userId);
}
