package com.cjt.mapper;

import com.cjt.entity.Activities;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjt.entity.Announces;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
public interface ActivitiesMapper extends BaseMapper<Activities> {

    List<Activities> clubGet(Integer clubId);

    List<Activities> managerGet(Integer clubId);

    Integer insertAct(String activityTitle,String activityCon,String activityDecs,String startTime,String endTime,String actPrice,String clubId);

    List<Activities> page();

    List<Activities> query(int activityId);

    List<Activities> search(String activityTitle,Integer clubsId);
}
