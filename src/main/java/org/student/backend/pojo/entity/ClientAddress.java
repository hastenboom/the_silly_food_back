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
public class ClientAddress {

    private Long id;

    private Long userId;

    /*like home, or workplace*/
    private String shortName;

    private String address;

    private Double latitude;

    private Double longitude;
}
