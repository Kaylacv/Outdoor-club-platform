package com.cjt.service;

import com.cjt.entity.Announces;
import com.cjt.entity.Goods;
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
public interface IGoodsService extends IService<Goods> {

    PageInfo<Goods> page(int pageCode, int pageSize);

    List<Goods> queryName(String goodName);




}
