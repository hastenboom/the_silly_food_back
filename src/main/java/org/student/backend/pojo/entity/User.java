package org.student.backend.pojo.entity;

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
public class User {

    private Long id;
    private String phone;
    private USER_ROLE role;

    @Nullable
    private String fullName;
    @Nullable
    private String email;
    @Nullable
    private String password;
    @Nullable
    private String avatarUrl;
}

