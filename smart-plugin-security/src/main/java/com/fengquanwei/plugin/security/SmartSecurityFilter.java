package com.fengquanwei.plugin.security;

import com.fengquanwei.plugin.security.realm.SmartCustomRealm;
import com.fengquanwei.plugin.security.realm.SmartJdbcRealm;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.CachingSecurityManager;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 安全过滤器
 *
 * @author zclhit
 **/
public class SmartSecurityFilter extends ShiroFilter {
    @Override
    public void init() throws Exception {
        super.init();
        WebSecurityManager webSecurityManager = super.getSecurityManager();

        // 设置 Realm，可同时支持多个 Realm，并按照先后顺序用逗号分隔
        setRealms(webSecurityManager);

        // 设置 Cache，用于减少数据库查询次数，降低 I/O 访问
        setCache(webSecurityManager);
    }

    private void setRealms(WebSecurityManager webSecurityManager) {
        String securityRealms = SecurityConfig.getRealms(); // 读取 smart.properties 中的 smart.plugin.security.realms 配置项
        if (securityRealms != null) {
            String[] securityRealmArray = securityRealms.split(","); // 根据逗号拆分
            if (securityRealmArray.length > 0) {
                Set<Realm> realms = new LinkedHashSet<Realm>(); // 使 Realm 具备唯一性与顺序性
                for (String securityRealm : securityRealmArray) {
                    if (securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_JDBC)) {
                        addJdbcRealm(realms); // 添加基于 JDBC 的 Realm，需配置相关 SQL 查询语句
                    } else if (securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_CUSTOM)) {
                        addCustomRealm(realms); // 添加基于定制化的 Realm，需实现 SmartSecurity 接口
                    }
                }
                RealmSecurityManager realmSecurityManager = (RealmSecurityManager) webSecurityManager;
                realmSecurityManager.setRealms(realms); // 设置 Realm
            }
        }
    }

    private void addJdbcRealm(Set<Realm> realms) {
        SmartJdbcRealm smartJdbcRealm = new SmartJdbcRealm();
        realms.add(smartJdbcRealm);
    }

    private void addCustomRealm(Set<Realm> realms) {
        // 读取 smart.properties 中的 smart.plugin.security.custom.class 配置项
        SmartSecurity smartSecurity = SecurityConfig.getSmartSecurity();
        // 添加自己实现的Realm
        SmartCustomRealm smartCustomRealm = new SmartCustomRealm(smartSecurity);
        realms.add(smartCustomRealm);
    }

    private void setCache(WebSecurityManager webSecurityManager) {
        // 读取 smart.properties 中的 smart.plugin.security.cache 配置项
        if (SecurityConfig.isCache()) {
            CachingSecurityManager cachingSecurityManager = (CachingSecurityManager) webSecurityManager;
            cachingSecurityManager.setCacheManager(new MemoryConstrainedCacheManager());
        }
    }
}
