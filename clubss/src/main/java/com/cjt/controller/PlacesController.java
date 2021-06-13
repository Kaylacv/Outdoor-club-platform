package com.cjt.controller;


import com.cjt.entity.Announces;
import com.cjt.entity.Places;
import com.cjt.mapper.PlacesMapper;
import com.cjt.service.IPlacesService;
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
@RequestMapping("/api/cjt/places")
public class PlacesController {
    @Autowired
    private IPlacesService placesService;
    @Autowired
    private PlacesMapper placesMapper;

    @RequestMapping("getList")
    public Object getList(Integer clubId){
        return placesService.getList(clubId);
    }

    @RequestMapping("delete")
    public Object delete(Integer placeId){
        return placesService.removeById(placeId);
    }

    @RequestMapping("insert")
    public Object insert(Places places){
        return placesService.save(places);
    }

    @RequestMapping("update")
    public Object update(Places places){
        return placesService.updateById(places);
    }

    @CrossOrigin
    @RequestMapping("clubpage")
    //分页
    public PageInfo<Places> clubpage(int clubsId, int pageCode, int pageSize) {
        PageInfo<Places> pageInfo = placesService.clubpage(clubsId,pageCode, pageSize);
        return pageInfo;
    }

    @RequestMapping("seach")
    public Object search(String placeName,Integer clubsId){
        return placesMapper.search(placeName, clubsId);
    }
}
