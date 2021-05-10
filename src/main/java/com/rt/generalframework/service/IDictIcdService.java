package com.rt.generalframework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rt.generalframework.entity.DictIcd;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ideaGenerator
 * @since 2021-03-08
 */
public interface IDictIcdService {

    List<DictIcd> getIcdList();

    boolean addIcd(DictIcd icd);

    boolean updateIcd(DictIcd icd);
}
