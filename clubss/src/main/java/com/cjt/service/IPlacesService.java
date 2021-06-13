package com.cjt.service;

import com.cjt.entity.Announces;
import com.cjt.entity.Places;
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
public interface IPlacesService extends IService<Places> {
    List<Places> getList(Integer clubId);
    PageInfo<Places> clubpage(int clubsId, int pageCode, int pageSize);

}
