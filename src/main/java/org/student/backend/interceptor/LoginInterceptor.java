package org.student.backend.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.student.backend.login.UserDTO;
import org.student.backend.login.UserDTOHolder;

/**
 * @author Student
 */
@Slf4j
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getMethod().equals("OPTIONS")){
            return true;
        }
        UserDTO user = UserDTOHolder.getUser();
        if (user == null) {
            response.setStatus(401);
            return false;
        }
        return true;
    }

}
