package com.cjt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.LocalDate;

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
public class Members implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "memberId", type = IdType.AUTO)
    private Integer memberId;

    @TableField("userName")
    private String userName;

    private Integer clubsId;

    private String clubsName;

    private String clubsKind;

    private String clubDecs;

    private String clubAddress;

    private String clubPic;

    private LocalDate clubTime;

    private String roles;

    private Boolean enabled;


}
