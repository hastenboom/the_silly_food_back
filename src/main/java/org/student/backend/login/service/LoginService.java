package org.student.backend.login.service;

import org.student.backend.login.LoginFormDTO;
import org.student.backend.pojo.common.Result;

/**
 * @author Student
 */

public interface LoginService {
    Result sendCode(String phone);

    Result login(LoginFormDTO loginFormDTO);
}
