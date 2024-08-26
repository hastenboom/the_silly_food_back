package org.student.backend.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Student
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private Long id;

    private String images;

    private String name;
    private String description;

    private String address;

    private LocalDateTime startAt;

    private LocalDateTime endAt;


}
