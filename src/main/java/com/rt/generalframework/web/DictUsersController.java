package com.rt.generalframework.web;

import com.rt.generalframework.entity.DictUsers;
import com.rt.generalframework.service.IDictUsersService;
import com.rt.global.JsonResult;
import com.rt.global.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class DictUsersController {

    @Autowired
    IDictUsersService iDictUsersService;

    @PostMapping("/getMyMsgUser")
    public JsonResult getMyMsgUser(DictUsers users) {
        return JsonResultUtil.success(iDictUsersService.getMyMsgUser(users));
    }

    @PostMapping("/getUnMyMsgUser")
    public JsonResult getUnMyMsgUser(DictUsers users) {
        return JsonResultUtil.success(iDictUsersService.getUnMyMsgUser(users));
    }

    @PostMapping("/getUserList")
    public JsonResult getUserList(DictUsers users) {
        return JsonResultUtil.success(iDictUsersService.getUserList(users));
    }

    @PostMapping("/updateUser")
    public JsonResult updateUser(DictUsers users) {
        iDictUsersService.updateUser(users);
        return JsonResultUtil.success();
    }

    @PostMapping("/addUser")
    public JsonResult addUser(DictUsers users) {
        iDictUsersService.addUser(users);
        return JsonResultUtil.success();
    }
}
