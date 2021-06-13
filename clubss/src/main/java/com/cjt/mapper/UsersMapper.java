package com.cjt.mapper;

import com.cjt.entity.Announces;
import com.cjt.entity.Users;
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
public interface UsersMapper extends BaseMapper<Users> {

    List<Users> queryByName(String userName);
    Integer queryId(String userName);
    String queryName(String userPhone);
    List<Users> page();


}
