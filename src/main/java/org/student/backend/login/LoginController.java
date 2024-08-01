package org.student.backend.login;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.student.backend.pojo.common.Result;

/**
 * @author Student
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login_code")
    public Result sendCode(@RequestParam("phone") String phone) {
        return loginService.sendCode(phone);
    }

    @PostMapping
    public Result login(@RequestBody LoginFormDTO loginFormDTO) {
        return loginService.login(loginFormDTO);
    }

}
