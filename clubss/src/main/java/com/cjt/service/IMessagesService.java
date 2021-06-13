package com.cjt.service;

import com.cjt.entity.Messages;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
public interface IMessagesService extends IService<Messages> {
    List<Messages> managerGet(Messages messages);
}
