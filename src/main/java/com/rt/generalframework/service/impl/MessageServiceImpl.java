package com.rt.generalframework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rt.generalframework.entity.DictUsers;
import com.rt.generalframework.entity.Message;
import com.rt.generalframework.mapper.MessageMapper;
import com.rt.generalframework.service.IMessageService;
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
 *
 * @author ideaGenerator
 * @since 2021-03-08
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<Message> getMsgList(Message m) {
        return messageMapper.getMyMesssage(m);
    }

    @Override
    public boolean saveMsg(Message m) {
        m.setMsgId(PKGeneratorCluster.nextPkStr());
        m.setCreateDate(new Date());
        return this.save(m);
    }

    @Override
    public void updateMsgRead(Message m) {
        QueryWrapper<Message> queryWrapper = new QueryWrapper();
        queryWrapper.eq(Message.MSG_SEND_ID, m.getMsgSendId());
        queryWrapper.eq(Message.MSG_RECIVCE_ID, m.getMsgRecivceId());
        m.setReaded("1");
        messageMapper.update(m, queryWrapper);
    }
}
