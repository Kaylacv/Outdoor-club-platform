package com.cjt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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
public class Activities implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "activityId", type = IdType.AUTO)
    private Integer activityId;

    @TableField("activityTitle")
    private String activityTitle;

    @TableField("activityCon")
    private Integer activityCon;

    @TableField("activityDecs")
    private String activityDecs;

    @TableField("upTime")
    private LocalDateTime upTime;

    @TableField("startTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startTime;

    @TableField("endTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endTime;

    @TableField("actPrice")
    private BigDecimal actPrice;

    @TableField("clubId")
    private Integer clubId;

    private String clubsName;

    private String checking;


}
