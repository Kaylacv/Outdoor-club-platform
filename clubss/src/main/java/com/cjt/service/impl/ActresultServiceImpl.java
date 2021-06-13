package com.cjt.service.impl;

import com.cjt.entity.Actresult;
import com.cjt.mapper.ActresultMapper;
import com.cjt.service.IActresultService;
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
public class ActresultServiceImpl extends ServiceImpl<ActresultMapper, Actresult> implements IActresultService {

    @Override
    public List<Actresult> actResult(Integer activtyId) {
        return baseMapper.actResult(activtyId);
    }

    @Override
    public List<Actresult> userResult(Integer userId) {
        return baseMapper.userResult(userId);
    }
}
