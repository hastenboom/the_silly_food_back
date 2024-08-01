package org.student.backend.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;
import org.student.backend.pojo.enumeration.USER_ROLE;

/**
 * @author Student
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginFormDTO {

    private String phone;
    private USER_ROLE role;

    @Nullable
    private String code;

    @Nullable
    private String password;

}
