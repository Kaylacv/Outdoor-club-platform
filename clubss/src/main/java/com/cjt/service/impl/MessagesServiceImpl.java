package com.cjt.service.impl;

import com.cjt.entity.Messages;
import com.cjt.mapper.MessagesMapper;
import com.cjt.service.IMessagesService;
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
public class MessagesServiceImpl extends ServiceImpl<MessagesMapper, Messages> implements IMessagesService {

    @Override
    public List<Messages> managerGet(Messages messages) {
        return baseMapper.managerGet(messages);
    }
}
