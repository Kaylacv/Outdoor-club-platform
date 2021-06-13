package com.cjt.service;

import com.cjt.entity.Announces;
import com.cjt.entity.Managers;
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
public interface IManagersService extends IService<Managers> {
    List<Managers> getAllList(String managerNo);

    Integer queryId(String managerNo);

    String queryName(String managerPhone);
}
