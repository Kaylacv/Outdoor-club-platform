package com.cjt.controller;


import com.cjt.entity.Announces;
import com.cjt.entity.Goods;
import com.cjt.mapper.GoodsMapper;
import com.cjt.service.IAnnouncesService;
import com.cjt.service.IGoodsService;
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
@RequestMapping("/cjt/goods")
public class GoodsController {
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private GoodsMapper goodsMapper;

    @RequestMapping("getById")
    public Object getById(Integer goodId){
        return goodsService.getById(goodId);
    }

    @RequestMapping("getAllList")
    public Object getAllList(){
        return goodsMapper.selectList(null);
    }

    @RequestMapping("insert")
    public Object Insert(Goods goods){
        return goodsService.save(goods);
    }

    @RequestMapping("deleteById")
    public Object Delete(Integer goodId){
        return goodsService.removeById(goodId);
    }

    @RequestMapping("update")
    public Object Update(Goods good){
        return goodsService.updateById(good);
    }

    @CrossOrigin
    @RequestMapping("page")
    //分页
    public PageInfo<Goods> page(int pageCode, int pageSize) {
        PageInfo<Goods> pageInfo = goodsService.page(pageCode, pageSize);
        return pageInfo;
    }

    @RequestMapping("queryName")
    public Object queryName(String goodName){
        return goodsService.queryName(goodName);
    }

}
