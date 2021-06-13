package com.cjt.service.impl;

import com.cjt.entity.Announces;
import com.cjt.entity.Orders;
import com.cjt.mapper.OrdersMapper;
import com.cjt.service.IOrdersService;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Override
    public List<Orders> managerGet(Orders orders) {
        return baseMapper.managerGet(orders);
    }

    @Override
    public PageInfo<Orders> page(int pageCode, int pageSize) {
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Orders> orders = baseMapper.page();

        return new PageInfo<>(orders);
    }

    @Override
    public List<Orders> queryName(String userName) {
        return baseMapper.queryName(userName);
    }

    @Override
    public PageInfo<Orders> userpage(int userId, int pageCode, int pageSize) {
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Orders> orders = baseMapper.userpage(userId);

        return new PageInfo<>(orders);
    }

    @Override
    public List<Object> echart(Integer year) {
        return baseMapper.echart(year);
    }
}
