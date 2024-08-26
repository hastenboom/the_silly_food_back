package org.student.backend.profile.client;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.student.backend.pojo.common.Result;
import org.student.backend.profile.UserService;

import java.net.http.HttpRequest;

/**
 * @author Student
 */

@RestController
@RequestMapping("/client/profile") // 类级别的基础路径
public class ClientProfileMainController {

    @Resource
    private UserService userService;

    @GetMapping
    public Result getClientProfile()
    {
        return userService.getClientProfile();
    }

    @GetMapping("/logout")
    public Result logoutFromClientProfile(HttpServletRequest request) {
        return userService.logoutFromClientProfile(request);
    }
}