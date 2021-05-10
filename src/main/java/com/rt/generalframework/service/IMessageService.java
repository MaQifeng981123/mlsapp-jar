package com.rt.generalframework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rt.generalframework.entity.Message;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ideaGenerator
 * @since 2021-03-08
 */
public interface IMessageService {

    List<Message> getMsgList(Message m);

    boolean saveMsg(Message m);

    void updateMsgRead(Message m);
}
