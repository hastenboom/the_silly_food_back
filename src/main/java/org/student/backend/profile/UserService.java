package org.student.backend.profile;

import jakarta.servlet.http.HttpServletRequest;
import org.student.backend.pojo.common.Result;

/**
 * @author Student
 */
public interface UserService {

    Result getClientProfile();

    Result logoutFromClientProfile(HttpServletRequest request);
}
