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
public class Actresult implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "resultId", type = IdType.AUTO)
    private Integer resultId;

    @TableField("userId")
    private Integer userId;

    private String userName;

    @TableField("activityId")
    private Integer activityId;

    private String activityTitle;

    @TableField("userRank")
    private Integer userRank;


}
