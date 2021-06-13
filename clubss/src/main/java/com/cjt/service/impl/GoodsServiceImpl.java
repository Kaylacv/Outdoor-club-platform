package com.cjt.service.impl;

import com.cjt.entity.Announces;
import com.cjt.entity.Goods;
import com.cjt.mapper.GoodsMapper;
import com.cjt.service.IGoodsService;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {


    @Override
    public PageInfo<Goods> page(int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Goods> goods = baseMapper.page();

        return new PageInfo<>(goods);
    }

    @Override
    public List<Goods> queryName(String goodName) {
        return baseMapper.queryName(goodName);
    }
}
