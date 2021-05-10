package com.rt.generalframework.mapper;

import cn.hutool.core.lang.Dict;
import com.rt.generalframework.entity.DictUsers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ideaGenerator
 * @since 2021-03-08
 */
public interface DictUsersMapper extends BaseMapper<DictUsers> {

    boolean updateUserSelective(DictUsers users);

    List getMyMsgUser(DictUsers users);
    List getUnMyMsgUser(DictUsers users);

}
