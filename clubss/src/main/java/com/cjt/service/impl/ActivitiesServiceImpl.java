package com.cjt.service.impl;

import com.cjt.entity.Activities;
import com.cjt.entity.Announces;
import com.cjt.mapper.ActivitiesMapper;
import com.cjt.service.IActivitiesService;
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
public class ActivitiesServiceImpl extends ServiceImpl<ActivitiesMapper, Activities> implements IActivitiesService {


    @Override
    public PageInfo<Activities> clubGet(int clubId, int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Activities> activities = baseMapper.clubGet(clubId);

        return new PageInfo<>(activities);
    }

    public PageInfo<Activities> managerGet(int clubId,int pageCode, int pageSize){
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Activities> activities = baseMapper.managerGet(clubId);

        return new PageInfo<>(activities);
    }

    @Override
    public Integer insertAct(String activityTitle,String activityCon,String activityDecs,String startTime,String endTime,String actPrice,String clubId) {
        return baseMapper.insertAct(activityTitle,activityCon,activityDecs,startTime,endTime,actPrice,clubId);
    }

    @Override
    public PageInfo<Activities> page(int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Activities> activities = baseMapper.page();

        return new PageInfo<>(activities);
    }

    @Override
    public List<Activities> query(int activityId) {
        return baseMapper.query(activityId);
    }
}
