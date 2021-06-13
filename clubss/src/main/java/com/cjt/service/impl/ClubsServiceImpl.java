package com.cjt.service.impl;

import com.cjt.entity.Announces;
import com.cjt.entity.Clubs;
import com.cjt.mapper.ClubsMapper;
import com.cjt.service.IClubsService;
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
public class ClubsServiceImpl extends ServiceImpl<ClubsMapper, Clubs> implements IClubsService {

    @Override
    public List<Clubs> querybyName(String query) {
        return baseMapper.querybyName(query);
    }

    @Override
    public Integer queryId(String clubName) {
        return baseMapper.queryId(clubName);
    }

    @Override
    public PageInfo<Clubs> page(int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Clubs> clubs = baseMapper.page();

        return new PageInfo<>(clubs);
    }

    @Override
    public Integer addClub(Clubs clubs) {
        return baseMapper.addClub(clubs);
    }

    @Override
    public PageInfo<Clubs> menpage(String userName, int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Clubs> clubs = baseMapper.menpage(userName);

        return new PageInfo<>(clubs);
    }
}
