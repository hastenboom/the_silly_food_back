package org.student.backend.login;

import org.student.backend.pojo.common.Result;

/**
 * @author Student
 */

public interface LoginService {
    Result sendCode(String phone);

    Result login(LoginFormDTO loginFormDTO);
}
