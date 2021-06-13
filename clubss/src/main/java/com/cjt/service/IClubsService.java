package com.cjt.service;

import com.cjt.entity.Announces;
import com.cjt.entity.Clubs;
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
public interface IClubsService extends IService<Clubs> {
    List<Clubs> querybyName(String query);

    Integer queryId(String clubName);

    PageInfo<Clubs> page(int pageCode, int pageSize);

    Integer addClub(Clubs clubs);

    PageInfo<Clubs> menpage(String userName,int pageCode, int pageSize);
}
