package com.cjt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjt.entity.Cars;
import com.cjt.entity.Orders;
import com.cjt.entity.Reserves;
import com.cjt.entity.Users;
import com.cjt.mapper.ReservesMapper;
import com.cjt.service.IReservesService;
import com.cjt.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@RequestMapping("/api/cjt/reserves")
public class ReservesController {

    @Autowired
    private ReservesMapper reservesMapper;
    @Autowired
    private IReservesService reservesService;

    @CrossOrigin
    @RequestMapping("managerGet")
    //分页
    public PageInfo<Reserves> managerGet(int clubId,int pageCode, int pageSize) {
        PageInfo<Reserves> pageInfo = reservesService.managerGet(clubId,pageCode, pageSize);
        return pageInfo;
    }


    @CrossOrigin
    @RequestMapping("managerPlace")
    //分页
    public PageInfo<Reserves> managerPlace(int clubId,int pageCode, int pageSize) {
        PageInfo<Reserves> pageInfo = reservesService.managerPlace(clubId,pageCode, pageSize);
        return pageInfo;
    }


    @CrossOrigin
    @RequestMapping("actOrder")
    //分页
    public PageInfo<Reserves> actOrder(int clubId,int pageCode, int pageSize) {
        PageInfo<Reserves> pageInfo = reservesService.actOrder(clubId,pageCode, pageSize);
        return pageInfo;
    }

    @CrossOrigin
    @RequestMapping("placeOrder")
    //分页
    public PageInfo<Reserves> placeOrder(int clubId,int pageCode, int pageSize) {
        PageInfo<Reserves> pageInfo = reservesService.placeOrder(clubId,pageCode, pageSize);
        return pageInfo;
    }

    @RequestMapping("delete")
    public Object delete(Integer reserveId){
        return reservesService.removeById(reserveId);
    }

    @PostMapping("addReserve")
    public Object addReserve(@RequestBody @Valid Reserves reserves){
        List<Reserves> reserve = reservesService.list(new QueryWrapper<Reserves>().eq("reserveDate", reserves.getReserveDate()));
        if (reserve.size()>5){
            return new Result(0, "已满5人，不可预约");
        }
         reservesMapper.addReserve(reserves);
        return new Result(1, "预约成功");
    }
}
