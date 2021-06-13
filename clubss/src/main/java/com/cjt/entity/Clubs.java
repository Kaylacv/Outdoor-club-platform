package com.cjt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDate;
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
public class Clubs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value ="clubsId", type = IdType.AUTO)
    private Integer clubsId;

    @TableField("clubsName")
    private String clubsName;

    @TableField("clubsKind")
    private String clubsKind;

    @TableField("clubDecs")
    private String clubDecs;

    @TableField("clubAddress")
    private String clubAddress;

    @TableField("clubPic")
    private String clubPic;

    @TableField("clubTime")
    private LocalDate clubTime;


    private Boolean enabled;

    private String license;

    private String clubpass;


    public Integer getClubsId() {
        return clubsId;
    }

    public void setClubsId(Integer clubsId) {
        this.clubsId = clubsId;
    }

    public String getClubsName() {
        return clubsName;
    }

    public void setClubsName(String clubsName) {
        this.clubsName = clubsName;
    }

    public String getClubsKind() {
        return clubsKind;
    }

    public void setClubsKind(String clubsKind) {
        this.clubsKind = clubsKind;
    }

    public String getClubDecs() {
        return clubDecs;
    }

    public void setClubDecs(String clubDecs) {
        this.clubDecs = clubDecs;
    }

    public String getClubAddress() {
        return clubAddress;
    }

    public void setClubAddress(String clubAddress) {
        this.clubAddress = clubAddress;
    }

    public String getClubPic() {
        return clubPic;
    }

    public void setClubPic(String clubPic) {
        this.clubPic = clubPic;
    }

    public LocalDate getClubTime() {
        return clubTime;
    }

    public void setClubTime(LocalDate clubTime) {
        this.clubTime = clubTime;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getClubpass() {
        return clubpass;
    }

    public void setClubpass(String clubpass) {
        this.clubpass = clubpass;
    }
}
