package com.cjt.service.impl;

import com.cjt.entity.Cars;
import com.cjt.entity.Clubs;
import com.cjt.mapper.CarsMapper;
import com.cjt.service.ICarsService;
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
 * @since 2021-04-09
 */
@Service
public class CarsServiceImpl extends ServiceImpl<CarsMapper, Cars> implements ICarsService {

    @Override
    public PageInfo<Cars> page(String userName,int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Cars> cars = baseMapper.page(userName);

        return new PageInfo<>(cars);
    }


}
