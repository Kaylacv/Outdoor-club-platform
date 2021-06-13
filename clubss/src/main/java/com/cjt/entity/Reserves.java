package com.cjt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.LocalTime;

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
public class Reserves implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 物流id
     */
    @TableId(value = "reserveId", type = IdType.AUTO)
    private Integer reserveId;

    @TableField("userName")
    private String userName;
    /**
     * 开始时间
     */
    @TableField("reserveDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reserveDate;


    /**
     * 结束时间
     */
    @TableField("activityId")
    private Integer activityId;

    private String activityTitle;

    private Float actPrice;

    @TableField("placeId")
    private Integer placeId;

    private String placeName;

    private Float placePrice;


    /**
     * 员工id
     */
    @TableField("userPay")
    private String userPay;

    @TableField("payTime")
    private LocalDateTime payTime;

    @TableField("clubId")
    private Integer clubId;

    private String clubsName;

    @TableField("usertatus")
    private String usestatus;
}
