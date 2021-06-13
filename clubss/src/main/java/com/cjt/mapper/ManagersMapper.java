package com.cjt.mapper;

import com.cjt.entity.Managers;
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
public interface ManagersMapper extends BaseMapper<Managers> {

    List<Managers> getAllList(String managerNo);

    Integer queryId(String managerNo);

    String queryName(String managerPhone);
}
