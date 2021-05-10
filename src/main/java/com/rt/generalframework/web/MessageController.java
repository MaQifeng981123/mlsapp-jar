package com.rt.generalframework.web;

import com.rt.generalframework.entity.Message;
import com.rt.generalframework.service.IMessageService;
import com.rt.global.JsonResult;
import com.rt.global.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    IMessageService iMessageService;


    // send message
    @PostMapping("/sendMsg")
    public JsonResult sendMsg(Message m) {
        iMessageService.saveMsg(m);
        return JsonResultUtil.success();
    }

    // get message list
    @PostMapping("/getMyMsgList")
    public JsonResult getMyMsgList(Message m) {
        return JsonResultUtil.success(iMessageService.getMsgList(m));
    }

    @PostMapping("/updateMsgRead")
    public JsonResult updateMsgRead(Message m) {
        iMessageService.updateMsgRead(m);
        return JsonResultUtil.success();
    }
}
