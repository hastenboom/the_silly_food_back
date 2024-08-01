package org.student.backend.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Student
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//save in cache
public class UserDTO {
    private Long id;
    private String avaUrl;
    private String fullName;
    private String email;
}
