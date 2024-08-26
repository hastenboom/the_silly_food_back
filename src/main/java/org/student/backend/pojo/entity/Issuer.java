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
public class Issuer {

    @TableId(type= IdType.AUTO)
    private Long id;

    private String name;

    private String logoUrl;
}
