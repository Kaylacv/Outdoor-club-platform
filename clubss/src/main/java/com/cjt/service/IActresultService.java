package com.cjt.service;

import com.cjt.entity.Actresult;
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
public interface IActresultService extends IService<Actresult> {
    List<Actresult> actResult(Integer activtyId);

    List<Actresult> userResult(Integer userId);
}
