package com.cjt.mapper;

import com.cjt.entity.Messages;
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
public interface MessagesMapper extends BaseMapper<Messages> {


    List<Messages> managerGet(Messages messages);
}
