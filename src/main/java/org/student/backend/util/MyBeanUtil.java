package org.student.backend.util;

import lombok.val;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Student
 */
public class MyBeanUtil {

    public static <T> Map<String, String> stringBeanToMap(T bean) {

        Field[] declaredFields = bean.getClass().getDeclaredFields();
        Map<String, String> fieldMap = new HashMap<>();

        for (Field field : declaredFields) {
            field.setAccessible(true);

            String fieldName = field.getName();

            String fieldValue;

            try {
                if (field.get(bean) == null) {
                    fieldValue = "";
                }
                else {
                    fieldValue = field.get(bean).toString();
                }
            }
            catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            fieldMap.put(fieldName, fieldValue);
        }

        return fieldMap;
    }


    public static <T> T mapToBean(Map<Object, Object> objectMap, Class<T> beanClass) {
        T bean;
        try {
            bean = beanClass.newInstance();
        }
        catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Field[] declaredFields = beanClass.getDeclaredFields();

        for (val field : declaredFields) {
            String fieldName = field.getName();
            for (val entry : objectMap.entrySet()) {
                if (fieldName.equals(entry.getKey())) {
                    try {
                        field.set(bean, entry.getValue());
                    }
                    catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
        return bean;
    }
}
