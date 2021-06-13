package com.cjt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "goodId", type = IdType.AUTO)
    private Integer goodId;

    @TableField("goodName")
    private String goodName;

    @TableField("goodPic1")
    private String goodPic1;

    @TableField("goodPic2")
    private String goodPic2;

    @TableField("goodPic3")
    private String goodPic3;

    @TableField("goodPic4")
    private String goodPic4;

    @TableField("goodPrice")
    private Float goodPrice;

    @TableField("goodDecs")
    private String goodDecs;


}
