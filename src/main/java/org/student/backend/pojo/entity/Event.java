package org.student.backend.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Student
 */
@Data
public class Event {

    private Long id;

    private String images;

    private String name;
    private String description;

    private String address;

    private LocalDateTime startAt;

    private LocalDateTime endAt;


}
