package org.student.backend.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Student
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @TableId(type= IdType.AUTO)
    private Long id;

    private Long userId;

    private String shortAddr;

    private String longAddr;

    /*-180W to 180*/
    private Double latitude;

    /*-90S to 90*/
    private Double longitude;

}
