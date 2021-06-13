package com.cjt.controller;


import com.cjt.entity.Announces;
import com.cjt.entity.Goods;
import com.cjt.entity.Orders;
import com.cjt.mapper.OrdersMapper;
import com.cjt.service.IOrdersService;
import com.cjt.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@RequestMapping("/cjt/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;
    @Autowired
    private OrdersMapper ordersMapper;
    @RequestMapping("managerGet")
    public Object managerGet(Orders orders){
        return ordersService.managerGet(orders);
    }

    @RequestMapping("selectById")
    public Object selectById(Integer orderId){
        return ordersMapper.selectById(orderId);
    }

    @CrossOrigin
    @RequestMapping("page")
    //分页
    public PageInfo<Orders> page(int pageCode, int pageSize) {
        PageInfo<Orders> pageInfo = ordersService.page(pageCode, pageSize);
        return pageInfo;
    }

    @RequestMapping("queryName")
    public Object queryName(String userName){
        return ordersService.queryName(userName);
    }

    @CrossOrigin
    @RequestMapping("userpage")
    //分页
    public PageInfo<Orders> userpage(int userId,int pageCode, int pageSize) {
        PageInfo<Orders> pageInfo = ordersService.userpage(userId,pageCode, pageSize);
        return pageInfo;
    }

    @CrossOrigin
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public Result order(Integer year){
        //调用查询年龄段的方法
        List<Object> allTOAgeService = ordersService.echart(year);
        //定义List集合转化为纯数组
        List<Object> ints = new ArrayList<>();
        ints.add(allTOAgeService);
        return new Result(0,"成功",ints);
    }


}
