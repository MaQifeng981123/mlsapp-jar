package com.rt.generalframework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rt.generalframework.entity.DictIcd;
import com.rt.generalframework.entity.DictUsers;
import com.rt.global.JsonResult;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ideaGenerator
 * @since 2021-03-08
 */
public interface IDictUsersService {

    List<DictUsers> getUserList(DictUsers users);

    boolean updateUser(DictUsers users);

    boolean addUser(DictUsers users);

    JsonResult login(DictUsers users);

    List getMyMsgUser(DictUsers users);
    List getUnMyMsgUser(DictUsers users);
}
