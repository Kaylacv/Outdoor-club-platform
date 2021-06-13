package com.cjt.mapper;

import com.cjt.entity.Announces;
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
public interface AnnouncesMapper extends BaseMapper<Announces> {

    List<Announces> managerGet(Announces announces);

    List<Announces> clubpage(Integer clubsId);

    Integer managerInsert(String announcetitle,String announcecontent);

    List<Announces> clubGet(Integer clubsId);

    Integer clubInsert(String announcetitle,String announcecontent,Integer clubId);

    String query(Integer announceId);

    List<Announces> queryTitle(String announcetitle,Integer clubsId);

    Integer addAnnounce(Announces announces);
}
