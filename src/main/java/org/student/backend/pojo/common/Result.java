package org.student.backend.pojo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Student
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private String errorMsg;
    private Object data;
    private Long total;

    public static Result ok() {
        return new Result(1, null, null, null);
    }

    public static Result ok(Object data) {
        return new Result(1, null, data, null);
    }

    public static Result ok(List<?> data, Long total) {
        return new Result(1, null, data, total);
    }

    public static Result fail(String errorMsg) {
        return new Result(2, errorMsg, null, null);
    }

}
