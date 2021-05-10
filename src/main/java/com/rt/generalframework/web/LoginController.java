package com.rt.generalframework.web;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.rt.generalframework.entity.DictUsers;
import com.rt.generalframework.service.IDictUsersService;
import com.rt.global.JsonResult;
import com.rt.global.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    IDictUsersService iDictUsersService;

    // login method
    @PostMapping("/login")
    public JsonResult login(DictUsers users) {
        String loginId = users.getLoginId();
        String pwd = users.getPassword();
        if (StringUtils.isEmpty(loginId) || StringUtils.isEmpty(pwd)) {
            return JsonResultUtil.failure();
        }
        return iDictUsersService.login(users);
    }
}
