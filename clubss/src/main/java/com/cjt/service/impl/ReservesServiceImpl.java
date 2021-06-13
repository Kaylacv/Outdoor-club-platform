package com.cjt.service.impl;

import com.cjt.entity.Announces;
import com.cjt.entity.Reserves;
import com.cjt.mapper.ReservesMapper;
import com.cjt.service.IReservesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
@Service
public class ReservesServiceImpl extends ServiceImpl<ReservesMapper, Reserves> implements IReservesService {


    @Override
    public PageInfo<Reserves> managerGet(int clubId, int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Reserves> reserves = baseMapper.managerGet(clubId);

        return new PageInfo<>(reserves);
    }

    @Override
    public PageInfo<Reserves> managerPlace(int clubId, int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Reserves> reserves = baseMapper.managerPlace(clubId);

        return new PageInfo<>(reserves);
    }


    @Override
    public PageInfo<Reserves> actOrder(int clubId, int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Reserves> reserves = baseMapper.actOrder(clubId);

        return new PageInfo<>(reserves);
    }

    @Override
    public PageInfo<Reserves> placeOrder(int clubId, int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Reserves> reserves = baseMapper.placeOrder(clubId);

        return new PageInfo<>(reserves);
    }


}
