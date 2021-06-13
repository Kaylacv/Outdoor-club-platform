package com.cjt.service;

import com.cjt.entity.Clubs;
import com.cjt.entity.Users;
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
public interface IUsersService extends IService<Users> {
    List<Users> queryByName(String userName);

    Integer queryId(String userName);

    String queryName(String userPhone);

    PageInfo<Users> page(int pageCode, int pageSize);


}
