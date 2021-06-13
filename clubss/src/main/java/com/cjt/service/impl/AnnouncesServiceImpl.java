package com.cjt.service.impl;

import com.cjt.entity.Announces;
import com.cjt.mapper.AnnouncesMapper;
import com.cjt.service.IAnnouncesService;
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
public class AnnouncesServiceImpl extends ServiceImpl<AnnouncesMapper, Announces> implements IAnnouncesService {

    @Override
    public List<Announces> managerGet(Announces announces) {
        return baseMapper.managerGet(announces);
    }

    @Override
    public PageInfo<Announces> clubpage(int clubsId,int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Announces> announce = baseMapper.clubpage(clubsId);

        return new PageInfo<>(announce);
    }

    @Override
    public Integer managerInsert(String announcetitle,String announcecontent) {
        return baseMapper.managerInsert(announcetitle,announcecontent);
    }


    @Override
    public List<Announces> clubGet(Integer clubsId) {
        return baseMapper.clubGet(clubsId);
    }

    @Override
    public Integer clubInsert(String announcetitle,String announcecontent,Integer clubId) {
        return baseMapper.clubInsert(announcetitle,announcecontent,clubId);
    }

    @Override
    public String query(Integer announceId) {
        return baseMapper.query(announceId);
    }


    @Override
    public List<Announces> queryTitle(String announcetitle,Integer clubsId) {
        return baseMapper.queryTitle(announcetitle,clubsId);
    }

    @Override
    public Integer addAnnounce(Announces announces) {
        return baseMapper.addAnnounce(announces);
    }
}
