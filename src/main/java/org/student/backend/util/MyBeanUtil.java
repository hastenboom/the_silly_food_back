package org.student.backend.util;

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
}
