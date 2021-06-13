package com.cjt.mapper;

import com.cjt.entity.Announces;
import com.cjt.entity.Goods;
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
public interface GoodsMapper extends BaseMapper<Goods> {
    List<Goods> page();

    List<Goods> queryName(String goodName);
}
