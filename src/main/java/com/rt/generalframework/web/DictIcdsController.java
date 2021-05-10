package com.rt.generalframework.web;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.rt.generalframework.entity.DictIcd;
import com.rt.generalframework.service.IDictIcdService;
import com.rt.global.JsonResult;
import com.rt.global.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dictIcd")
public class DictIcdsController {

    @Autowired
    IDictIcdService iDictIcdService;

    @PostMapping("/getIcdList")
    public JsonResult getIcdList() {
        return JsonResultUtil.success(iDictIcdService.getIcdList());
    }

    @PostMapping("/addIcd")
    public JsonResult addIcd(DictIcd icd) {
        iDictIcdService.addIcd(icd);
        return JsonResultUtil.success();
    }

    @PostMapping("/updateIcd")
    public JsonResult updateIcd(DictIcd icd) {
        if (StringUtils.isEmpty(icd.getIcdCode())) {
            return JsonResultUtil.failure();
        }
        iDictIcdService.updateIcd(icd);
        return JsonResultUtil.success();
    }
}
