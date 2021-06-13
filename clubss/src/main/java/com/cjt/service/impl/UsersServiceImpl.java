package com.cjt.service.impl;


import com.cjt.entity.Users;
import com.cjt.mapper.UsersMapper;
import com.cjt.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Override
    public List<Users> queryByName(String userName) {
        return baseMapper.queryByName(userName);
    }

    @Override
    public Integer queryId(String userName) {
        return baseMapper.queryId(userName);
    }

    @Override
    public String queryName(String userPhone) {
        return baseMapper.queryName(userPhone);
    }

    @Override
    public PageInfo<Users> page(int pageCode, int pageSize) {
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Users> users = baseMapper.page();

        return new PageInfo<>(users);
    }





}
