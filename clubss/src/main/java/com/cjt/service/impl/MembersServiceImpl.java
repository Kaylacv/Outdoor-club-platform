package com.cjt.service.impl;

import com.cjt.entity.Clubs;
import com.cjt.entity.Members;
import com.cjt.mapper.MembersMapper;
import com.cjt.service.IMembersService;
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
public class MembersServiceImpl extends ServiceImpl<MembersMapper, Members> implements IMembersService {

    @Override
    public String roleById(Integer userId) {
        return baseMapper.roleById(userId);
    }

    @Override
    public List<Members> queryByclubId(Integer clubId) {
        return baseMapper.queryByclubId(clubId);
    }

    @Override
    public PageInfo<Members> page(String userName, int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Members> members = baseMapper.page(userName);

        return new PageInfo<>(members);
    }

    @Override
    public Integer add(String userName, String clubName) {
        return baseMapper.add(userName, clubName);
    }

    @Override
    public PageInfo<Members> clubpage(String clubsName, int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Members> members = baseMapper.clubpage(clubsName);

        return new PageInfo<>(members);
    }

    @Override
    public Integer join(Members members) {
        return baseMapper.join(members);
    }

    @Override
    public PageInfo<Members> mempage(String userName, int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Members> members = baseMapper.mempage(userName);

        return new PageInfo<>(members);
    }


}
