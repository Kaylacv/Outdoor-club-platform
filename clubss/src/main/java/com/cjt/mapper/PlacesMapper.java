package com.cjt.mapper;

import com.cjt.entity.Announces;
import com.cjt.entity.Places;
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
public interface PlacesMapper extends BaseMapper<Places> {

    List<Places> getList(Integer clubId);

    List<Places> clubpage(Integer clubsId);

    List<Places> search(String placeName,Integer clubsId);
}
