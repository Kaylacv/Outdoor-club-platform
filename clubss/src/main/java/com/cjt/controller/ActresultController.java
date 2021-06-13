package com.cjt.controller;


import com.cjt.service.IActivitiesService;
import com.cjt.service.IActresultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>，
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/cjt/actresult")
public class ActresultController {

    @Autowired
    private IActresultService activitiesService;

    @RequestMapping("actResult")
    public Object actResult(Integer activityId){
        return activitiesService.actResult(activityId);
    }

    @RequestMapping("userResult")
    public Object userResult(Integer userId){ return activitiesService.userResult(userId);}
}
