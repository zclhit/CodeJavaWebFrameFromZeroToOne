package org.smart4j.framework;

import org.smart4j.framework.helper.*;
import org.smart4j.framework.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 *
 */
public final class HelperLoader {

    public static void init() {
        // AopHelper要在IocHelper之前加载
        // 因为首先需要通过AopHelper获取代理对象，然后才能通过IocHelper进行依赖注入
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class, // 先获取所有的代理对象
                IocHelper.class, // 然后进行依赖注入
                ControllerHelper.class
        };
        for (Class<?> clz : classList) {
            ClassUtil.loadClass(clz.getName(), true);
        }
    }

    public static void main(String[] args) {
        init();
    }
}
