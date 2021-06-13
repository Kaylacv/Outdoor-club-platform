package com.cjt.service;

import com.cjt.entity.Activities;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cjt.entity.Announces;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
public interface IActivitiesService extends IService<Activities> {
    PageInfo<Activities> clubGet(int clubId,int pageCode, int pageSize);

    PageInfo<Activities> managerGet(int clubId,int pageCode, int pageSize);

    Integer insertAct(String activityTitle,String activityCon,String activityDecs,String startTime,String endTime,String actPrice,String clubId);

    PageInfo<Activities> page(int pageCode, int pageSize);

    List<Activities> query(int activityId);
}
