package com.songshu.pressure.test.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songshu.pressure.test.demo.model.entiry.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 鼠笑天
 * @date 2019/12/24
 */
@Mapper
public interface UserDAO extends BaseMapper<UserDO> {


}
