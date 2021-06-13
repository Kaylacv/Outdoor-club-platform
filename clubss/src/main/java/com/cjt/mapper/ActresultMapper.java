package com.cjt.mapper;

import com.cjt.entity.Actresult;
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
public interface ActresultMapper extends BaseMapper<Actresult> {

    List<Actresult> actResult(Integer activtyId);

    List<Actresult> userResult(Integer userId);

}
