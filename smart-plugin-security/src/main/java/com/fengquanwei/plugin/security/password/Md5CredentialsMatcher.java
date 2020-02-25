package com.fengquanwei.plugin.security.password;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.smart4j.framework.util.CodecUtil;

/**
 * Md5 密码匹配器
 *
 * @author zclhit
 **/
public class Md5CredentialsMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        // 获取从表单提交过来的密码、明文，尚未通过 MD5 加密
        String submitted = String.valueOf(((UsernamePasswordToken) authenticationToken).getPassword());

        // 获取数据库中存储的密码，已通过 MD5 加密
        String encrypted = String.valueOf(authenticationInfo.getCredentials());

        return CodecUtil.md5Hex(submitted).equals(encrypted);
    }
}
