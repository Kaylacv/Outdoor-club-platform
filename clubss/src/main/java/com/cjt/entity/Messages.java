package com.cjt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Messages implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "massageId", type = IdType.AUTO)
    private Integer massageId;

    @TableField("massageCon")
    private String massageCon;

    @TableField("userId")
    private Integer userId;

    private String userName;

    @TableField("clubId")
    private Integer clubId;

    @TableField("massageTime")
    private LocalDateTime massageTime;


}
