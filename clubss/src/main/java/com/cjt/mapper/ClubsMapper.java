package com.cjt.mapper;

import com.cjt.entity.Clubs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjt.entity.Goods;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
public interface ClubsMapper extends BaseMapper<Clubs> {

    List<Clubs> getAllList();

    List<Clubs> querybyName(String query);

    Integer queryId(String clubName);

    List<Clubs> page();

    Integer addClub(Clubs clubs);

    List<Clubs> menpage(String userName);

    Integer updateStatus(Integer clubsId,Boolean enabled);
}
