package com.cjt.mapper;

import com.cjt.entity.Announces;
import com.cjt.entity.Goods;
import com.cjt.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
public interface OrdersMapper extends BaseMapper<Orders> {
    List<Orders> managerGet(Orders orders);
    List<Orders> page();
    List<Orders> queryName(String userName);
    List<Orders> userpage(Integer userId);
    List<Object> echart(Integer year);
}
