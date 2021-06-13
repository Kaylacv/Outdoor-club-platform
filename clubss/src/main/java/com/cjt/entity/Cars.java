package com.cjt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "carId", type = IdType.AUTO)
    private Integer carId;

    @TableField("goodId")
    private Integer goodId;

    private String cover;

    private String title;

    @TableField("userName")
    private String userName;

    private Float goodPrice;

    @TableField("goodCount")
    private Integer goodCount;

    @TableField("cprice")
    private BigDecimal cprice;


}
