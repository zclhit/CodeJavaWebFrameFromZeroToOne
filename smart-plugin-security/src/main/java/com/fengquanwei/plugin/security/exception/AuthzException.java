package com.fengquanwei.plugin.security.exception;

/**
 * 授权异常（当权限无效时抛出）
 *
 * @author fengquanwei
 * @create 2017/12/11 19:59
 **/
public class AuthzException extends RuntimeException {

    public AuthzException() {
        super();
    }

    public AuthzException(String message) {
        super(message);
    }

    public AuthzException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthzException(Throwable cause) {
        super(cause);
    }
}
