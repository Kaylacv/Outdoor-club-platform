package com.cjt.service;

import com.cjt.entity.Members;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cjt.entity.Orders;
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
public interface IMembersService extends IService<Members> {
    String roleById(Integer userId);

    List<Members> queryByclubId(Integer clubId);

    PageInfo<Members> page(String userName, int pageCode, int pageSize);

    Integer add(String userName,String clubName);

    PageInfo<Members> clubpage(String clubsName, int pageCode, int pageSize);

    Integer join(Members members);

    PageInfo<Members> mempage(String userName, int pageCode, int pageSize);
}
