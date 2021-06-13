package com.cjt.mapper;

import com.cjt.entity.Cars;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjt.entity.Clubs;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-04-09
 */
public interface CarsMapper extends BaseMapper<Cars> {

    List<Cars> page(String userName);

}
