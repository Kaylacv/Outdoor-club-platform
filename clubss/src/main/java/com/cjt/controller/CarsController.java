package com.cjt.controller;


import com.cjt.entity.Cars;
import com.cjt.entity.Clubs;
import com.cjt.result.Result;
import com.cjt.result.ResultFactory;
import com.cjt.service.ICarsService;
import com.cjt.service.IClubsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-04-09
 */
@RestController
@RequestMapping("/api/cjt/cars")
public class CarsController {
    @Autowired
    private ICarsService  carsService;

    @CrossOrigin
    @RequestMapping("page")
    //分页
    public PageInfo<Cars> page(String userName,int pageCode, int pageSize) {
        PageInfo<Cars> pageInfo = carsService.page(userName,pageCode, pageSize);
        return pageInfo;
    }

//    @GetMapping("/page/{size}/{page}")
//    public Result listArticles(@PathVariable("size") int size, @PathVariable("page") int page) {
//        return ResultFactory.buildSuccessResult(carsService.list(page - 1, size));
//    }

    @PostMapping("addCar")
    public Object addCar(@RequestBody @Valid Cars cars){
        return carsService.save(cars);
    }

}
