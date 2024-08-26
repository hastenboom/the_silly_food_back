package org.student.backend.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Student
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardIssuer {

    private Long id;

    private String name;

    private String logoUrl;
}
