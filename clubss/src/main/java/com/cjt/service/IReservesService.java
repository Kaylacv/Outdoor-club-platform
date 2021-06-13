package com.cjt.service;

import com.cjt.entity.Announces;
import com.cjt.entity.Reserves;
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
public interface IReservesService extends IService<Reserves> {
    PageInfo<Reserves> managerGet(int clubId, int pageCode, int pageSize);

    PageInfo<Reserves> managerPlace(int clubId, int pageCode, int pageSize);

    PageInfo<Reserves> actOrder(int clubId, int pageCode, int pageSize);

    PageInfo<Reserves> placeOrder(int clubId, int pageCode, int pageSize);
}
