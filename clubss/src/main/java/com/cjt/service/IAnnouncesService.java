package com.cjt.service;

import com.cjt.entity.Announces;
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
public interface IAnnouncesService extends IService<Announces> {
    List<Announces> managerGet(Announces announces);

    PageInfo<Announces> clubpage(int clubsId,int pageCode, int pageSize);

    Integer managerInsert(String announcetitle,String announcecontent);

    List<Announces> clubGet(Integer clubsId);

    Integer clubInsert(String announcetitle,String announcecontent,Integer clubId);

    String query(Integer announceId);

    List<Announces> queryTitle(String announcetitle,Integer clubsId);

    Integer addAnnounce(Announces announces);
}
