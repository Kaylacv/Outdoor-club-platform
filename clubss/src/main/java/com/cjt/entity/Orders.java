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
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "orderId", type = IdType.AUTO)
    private Integer orderId;

    @TableField("goodId")
    private String goodId;

    private String goodName;

    private String goodCount;

    private String goodPrice;

    @TableField("userId")
    private String userId;

    private String userName;

    @TableField("orderTime")
    private LocalDateTime orderTime;

    @TableField("startTime")
    private LocalDateTime startTime;

    @TableField("endTime")
    private LocalDateTime endTime;

    @TableField("userAddress")
    private String userAddress;

    @TableField("userPhone")
    private Integer userPhone;

    @TableField("userPay")
    private String userPay;

    @TableField("orderState")
    private String orderState;

    @TableField("orderReason")
    private String orderReason;


}
