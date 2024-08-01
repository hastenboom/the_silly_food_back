package org.student.backend.pojo.entity;


import lombok.Data;

/**
 * @author Student
 */
@Data
public class ClientAddress {

    private Long id;

    private Long userId;

    /*like home, or workplace*/
    private String shortName;

    private String address;

    private Double latitude;

    private Double longitude;
}
