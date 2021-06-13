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
public class Announces implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公告ID
     */
    @TableId(value = "announceId", type = IdType.AUTO)
    private Integer announceId;

    @TableField("announcetitle")
    private String announcetitle;

    @TableField("announcecontent")
    private String announcecontent;

    @TableField("announceTime")
    private LocalDateTime announceTime;

    @TableField("clubId")
    private Integer clubId;


}
