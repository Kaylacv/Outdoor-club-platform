package com.cjt.mapper;

import com.cjt.entity.Goods;
import com.cjt.entity.Members;
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
public interface MembersMapper extends BaseMapper<Members> {

    String roleById(Integer userId);

    List<Members> queryByclubId(Integer clubId);

    List<Members> page(String userName);

    Integer add(String userName,String clubName);

    List<Members> clubpage(String clubsName);

    Integer join(Members members);

    List<Members> mempage(String clubsName);

    List<Members> search(String ClubsName,String userName);

    List<Members> ifjoin(String userName,String clubsName);
}
