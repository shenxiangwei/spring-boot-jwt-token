package com.shenxiangwei.springbootjwttoken.filter.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * <br>
 * 标题: <br>
 * 描述: <br>
 *
 * @author shenxiangwei
 * @time 2019/10/23 10:37 上午
 */
@Data
public class UserInfo implements UserDetails {

    private static final long serialVersionUID = -7580618077423166554L;
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户组织机构路径
     */
    private String orgPath;

    /**
     * 组织机构编码
     */
    private Long orgId;

    /**
     * 组织机构名称
     */
    private String orgName;

    /**
     * 手机号
     */
    private String cellPhone;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 租户名称
     */
    private String tenantName;

    private String email;

    private String registerType;

    private String token;


    private boolean isAccountNonExpired = true;

    private boolean isAccountNonLocked = true;

    private boolean isCredentialsNonExpired = true;

    private boolean isEnabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        //获取用户授权能访问的url集合
////        return this.unstructuredMunes.stream()
////                .filter(menuInfo -> StringUtils.isNoneBlank(menuInfo.getUrl()))
////                .map(menuInfo -> new SimpleGrantedAuthority(SercurityConstants.PREFIX + menuInfo.getUrl()))
////                .distinct().collect(Collectors.toList());
//        return null;
//    }

//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
////    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
////    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
////    @Override
//    public boolean isAccountNonExpired() {
//        return isAccountNonExpired;
//    }
//
//    public void setAccountNonExpired(boolean accountNonExpired) {
//        isAccountNonExpired = accountNonExpired;
//    }
//
////    @Override
//    public boolean isAccountNonLocked() {
//        return isAccountNonLocked;
//    }
//
//    public void setAccountNonLocked(boolean accountNonLocked) {
//        isAccountNonLocked = accountNonLocked;
//    }
//
////    @Override
//    public boolean isCredentialsNonExpired() {
//        return isCredentialsNonExpired;
//    }
//
//    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
//        isCredentialsNonExpired = credentialsNonExpired;
//    }
//
////    @Override
//    public boolean isEnabled() {
//        return isEnabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        isEnabled = enabled;
//    }
//
//    public String getOrgPath() {
//        return orgPath;
//    }
//
//    public void setOrgPath(String orgPath) {
//        this.orgPath = orgPath;
//    }
//
//    public Long getOrgId() {
//        return orgId;
//    }
//
//    public void setOrgId(Long orgId) {
//        this.orgId = orgId;
//    }
//
//    public String getOrgName() {
//        return orgName;
//    }
//
//    public void setOrgName(String orgName) {
//        this.orgName = orgName;
//    }
//
//    public String getCellPhone() {
//        return cellPhone;
//    }
//
//    public void setCellPhone(String cellPhone) {
//        this.cellPhone = cellPhone;
//    }
//
//    public Long getTenantId() {
//        return tenantId;
//    }
//
//    public void setTenantId(Long tenantId) {
//        this.tenantId = tenantId;
//    }
//
//    public String getTenantName() {
//        return tenantName;
//    }
//
//    public void setTenantName(String tenantName) {
//        this.tenantName = tenantName;
//    }
//
//
//    @Override
//    public String toString() {
//        return "UserInfo{" +
//                "userId=" + userId +
//                ", name='" + name + '\'' +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", orgPath='" + orgPath + '\'' +
//                ", orgId=" + orgId +
//                ", orgName='" + orgName + '\'' +
//                ", cellPhone='" + cellPhone + '\'' +
//                ", tenantId=" + tenantId +
//                ", tenantName='" + tenantName + '\'' +
//                ", isAccountNonExpired=" + isAccountNonExpired +
//                ", isAccountNonLocked=" + isAccountNonLocked +
//                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
//                ", isEnabled=" + isEnabled +
//                '}';
//    }
}

