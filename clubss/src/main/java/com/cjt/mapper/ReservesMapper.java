package com.cjt.mapper;

import com.cjt.entity.Reserves;
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
public interface ReservesMapper extends BaseMapper<Reserves> {

    List<Reserves> managerGet(Integer clubId);

    List<Reserves>  managerPlace(Integer clubId);

    List<Reserves> actOrder(Integer clubId);

    List<Reserves> placeOrder(Integer clubId);

    Integer addReserve(Reserves reserves);
}
