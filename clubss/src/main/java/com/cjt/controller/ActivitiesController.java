package com.cjt.controller;


import com.cjt.entity.Activities;
import com.cjt.entity.Clubs;
import com.cjt.mapper.ActivitiesMapper;
import com.cjt.service.IActivitiesService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/api/cjt/activities")
public class ActivitiesController {

    @Autowired
    private IActivitiesService activitiesService;
    @Autowired
    public ActivitiesMapper activitiesMapper;

    @RequestMapping("clubGet")
    public Object clubGet(int clubId,int pageCode, int pageSize){
        PageInfo<Activities> pageInfo = activitiesService.clubGet(clubId,pageCode, pageSize);
        return pageInfo;
    }

    @RequestMapping("update")
    public Object update(Activities activities){
        return activitiesService.updateById(activities);
    }

    @RequestMapping("insertAct")
    public Object insertAct(String activityTitle,String activityCon,String activityDecs,String startTime,String endTime,String actPrice,String clubId){
        return activitiesService.insertAct(activityTitle,activityCon,activityDecs,startTime,endTime,actPrice,clubId);
    }

    @RequestMapping("delete")
    public Object delete(Integer activityId){
        return activitiesService.removeById(activityId);
    }


    @CrossOrigin
    @RequestMapping("page")
    //分页
    public PageInfo<Activities> page(int pageCode, int pageSize) {
        PageInfo<Activities> pageInfo = activitiesService.page(pageCode, pageSize);
        return pageInfo;
    }

    @CrossOrigin
    @RequestMapping("managerGet")
    //分页
    public PageInfo<Activities> managerGet(int clubId,int pageCode, int pageSize) {
        PageInfo<Activities> pageInfo = activitiesService.managerGet(clubId,pageCode, pageSize);
        return pageInfo;
    }

    @RequestMapping("query")
    public Object query(Integer activityId){
        return activitiesService.query(activityId);
    }

    @RequestMapping("search")
    public Object search(String activityTitle,Integer clubsId){
        return activitiesMapper.search(activityTitle,clubsId);
    }


}
