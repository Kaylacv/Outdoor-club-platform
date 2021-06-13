package com.cjt.service.impl;

import com.cjt.entity.Announces;
import com.cjt.entity.Places;
import com.cjt.mapper.PlacesMapper;
import com.cjt.service.IPlacesService;
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
public class PlacesServiceImpl extends ServiceImpl<PlacesMapper, Places> implements IPlacesService {

    @Override
    public List<Places> getList(Integer clubId) {
        return baseMapper.getList(clubId);
    }

    @Override
    public PageInfo<Places> clubpage(int clubsId, int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Places> places = baseMapper.clubpage(clubsId);

        return new PageInfo<>(places);
    }
}
