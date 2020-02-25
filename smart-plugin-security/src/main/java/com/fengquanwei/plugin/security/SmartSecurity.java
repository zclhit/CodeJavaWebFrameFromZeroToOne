package com.fengquanwei.plugin.security;

import java.util.Set;

/**
 * Smart Security 接口
 * 两种配置方法
 * 一、实现 SmartSecurity 接口，并在 smart.properties 文件中指定该接口的实现类
 * 二、无须实现 SmartSecurity 接口，直接在 smart.properties 文件中提供以下基于 SQL 的配置项：
 * smart.security.jdbc.authc_query：根据用户名获取密码
 * smart.security.jdbc.roles_query：根据用户名获取角色名集合
 * smart.security.jdbc.permissions_query：根据角色名获取权限名集合
 *
 * @author zclhit
 **/
public interface SmartSecurity {
    /**
     * 根据用户名获取密码
     */
    String getPassword(String username);

    /**
     * 根据用户名获取角色名集合
     */
    Set<String> getRoleNameSet(String username);

    /**
     * 根据角色名获取权限名集合
     */
    Set<String> getPermissionNameSet(String roleName);
}
