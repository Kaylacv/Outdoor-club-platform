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
public class Places implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "placeId", type = IdType.AUTO)
    private Integer placeId;

    @TableField("placeName")
    private String placeName;

    @TableField("placePic")
    private String placePic;

    @TableField("placeDecs")
    private String placeDecs;

    @TableField("clubId")
    private Integer clubId;

    @TableField("placePrice")
    private Float placePrice;


}
