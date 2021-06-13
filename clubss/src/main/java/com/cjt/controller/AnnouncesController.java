package com.cjt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cjt.entity.Announces;
import com.cjt.entity.Clubs;
import com.cjt.mapper.AnnouncesMapper;
import com.cjt.service.IAnnouncesService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/api/cjt/announces")
public class AnnouncesController {

    @Autowired
    private IAnnouncesService announcesService;
    @Autowired
    private AnnouncesMapper announcesMapper;

    @RequestMapping("managerGet")
    public Object managerGet(Announces announces){
        return announcesService.managerGet(announces);
    }
    @CrossOrigin
    @RequestMapping("clubpage")
    //分页
    public PageInfo<Announces> clubpage(int clubsId,int pageCode,int pageSize) {
        PageInfo<Announces> pageInfo = announcesService.clubpage(clubsId,pageCode, pageSize);
        return pageInfo;
    }

    @RequestMapping("managerInsert")
    public Object managerInsert(String announcetitle,String announcecontent){
        return announcesService.managerInsert(announcetitle,announcecontent);
    }

    @RequestMapping("queryTitle")
    public Object queryTitle(String announcetitle,Integer clubsId){
        return announcesService.queryTitle(announcetitle,clubsId);
    }

    @RequestMapping("clubGet")
    public Object clubGet(Integer clubsId){
        return announcesService.clubGet(clubsId);
    }

    @RequestMapping("clubInsert")
    public Object clubInsert(String announcetitle,String announcecontent,Integer clubId){
        return announcesService.clubInsert(announcetitle,announcecontent,clubId);
    }

    @RequestMapping("delete")
    public Object delete(Integer announceId){
        return announcesService.removeById(announceId);
    }

    @RequestMapping("queryById")
    public String queryById(Integer announceId){
        return announcesService.query(announceId);
    }

    @RequestMapping("query")
    public Object query(Integer announceId){
        return announcesMapper.selectById(announceId);
    }

    @RequestMapping("update")
    public Object update(Announces announces){
        return announcesService.updateById(announces);
    }

}
