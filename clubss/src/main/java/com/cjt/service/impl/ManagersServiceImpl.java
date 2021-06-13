package com.cjt.service.impl;

import com.cjt.entity.Announces;
import com.cjt.entity.Managers;
import com.cjt.mapper.ManagersMapper;
import com.cjt.service.IManagersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ManagersServiceImpl extends ServiceImpl<ManagersMapper, Managers> implements IManagersService {


    @Override
    public List<Managers> getAllList(String managerNo) {
        return baseMapper.getAllList(managerNo);
    }

    @Override
    public Integer queryId(String managerNo) {
        return baseMapper.queryId(managerNo);
    }

    @Override
    public String queryName(String managerPhone) {
        return baseMapper.queryName(managerPhone);
    }


}
