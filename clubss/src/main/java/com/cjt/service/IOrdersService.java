package com.cjt.service;

import com.cjt.entity.Goods;
import com.cjt.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
public interface IOrdersService extends IService<Orders> {
    List<Orders> managerGet(Orders orders);

    PageInfo<Orders> page(int pageCode, int pageSize);

    List<Orders> queryName(String userName);

    PageInfo<Orders> userpage(int userId,int pageCode, int pageSize);

    List<Object> echart(Integer year);
}
