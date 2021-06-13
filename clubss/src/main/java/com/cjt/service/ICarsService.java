package com.cjt.service;

import com.cjt.entity.Cars;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cjt.entity.Clubs;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2021-04-09
 */
public interface ICarsService extends IService<Cars> {
    PageInfo<Cars> page(String userName,int pageCode, int pageSize);
}
