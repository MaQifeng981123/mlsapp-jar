package com.rt.generalframework.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rt.generalframework.dto.DictUsersDto;
import com.rt.generalframework.entity.DictUsers;
import com.rt.generalframework.entity.Exams;
import com.rt.generalframework.entity.Message;
import com.rt.generalframework.mapper.DictUsersMapper;
import com.rt.generalframework.mapper.MessageMapper;
import com.rt.generalframework.service.IDictUsersService;
import com.rt.global.JsonResult;
import com.rt.global.JsonResultUtil;
import com.rt.pkgenerator.PKGeneratorCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Service
public class DictUsersServiceImpl extends ServiceImpl<DictUsersMapper, DictUsers> implements IDictUsersService {


    @Autowired
    DictUsersMapper dictUsersMapper;
    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<DictUsers> getUserList(DictUsers users) {
        QueryWrapper<DictUsers> query = Wrappers.query();
        String name = users.getName();
        if (!StringUtils.isEmpty(name)) {
            query.eq(DictUsers.NAME, name);
        }
        String loginId = users.getLoginId();
        String pwd = users.getPassword();
        if (StringUtils.isNotEmpty(loginId) && StringUtils.isNotEmpty(pwd)) {
            query.eq(DictUsers.LOGIN_ID, loginId);
            query.eq(DictUsers.PASSWORD, pwd);
        }
        String type = users.getStaffType();
        if (!StringUtils.isEmpty(type)) {
            query.eq(DictUsers.STAFF_TYPE, type);
        }
        return this.list(query);
    }

    @Override
    public boolean updateUser(DictUsers users) {
        return dictUsersMapper.updateUserSelective(users);
    }

    @Override
    public boolean addUser(DictUsers users) {
        users.setUserId(PKGeneratorCluster.nextPkStr());
        users.setCreateDate(new Date());
        return this.save(users);
    }

    @Override
    public JsonResult login(DictUsers users) {
        List<DictUsers> userList = this.getUserList(users);
        if (CollectionUtils.isEmpty(userList)) {
            return JsonResultUtil.failure();
        }
        return JsonResultUtil.success(userList.get(0));
    }

    @Override
    public List getMyMsgUser(DictUsers users) {
        List<DictUsersDto> myMsgUser = dictUsersMapper.getMyMsgUser(users);
        if (CollectionUtil.isNotEmpty(myMsgUser)) {
            for (DictUsersDto dictUsers : myMsgUser) {
                QueryWrapper<Message> queryWrapper = new QueryWrapper();
                queryWrapper.eq(Message.MSG_SEND_ID, dictUsers.getUserId());
                queryWrapper.eq(Message.MSG_RECIVCE_ID, users.getUserId());
                queryWrapper.orderByDesc(Message.CREATE_DATE);
                List<Message> messageList = messageMapper.selectList(queryWrapper);
                if (CollectionUtil.isNotEmpty(messageList)) {
                    Message message = messageList.get(0);
                    dictUsers.setLastMsgContent(message.getMsgData());
                    dictUsers.setLastMsgDate(message.getCreateDate());
                }
                queryWrapper.eq(Message.READED, "0");
                Integer count = messageMapper.selectCount(queryWrapper);
                dictUsers.setUnReadMsgCount(count);
            }
        }
        return myMsgUser;
    }

    @Override
    public List getUnMyMsgUser(DictUsers users) {
        return dictUsersMapper.getUnMyMsgUser(users);
    }
}
