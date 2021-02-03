package utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-10 19:13
 */
public class WebUtils {
    public static <T> T setParamToBean(T bean, Map value){
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String str, int defaultValue){
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
