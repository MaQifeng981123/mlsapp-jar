package com.rt.generalframework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rt.generalframework.entity.DictIcd;
import com.rt.generalframework.entity.DictUsers;
import com.rt.generalframework.mapper.DictIcdMapper;
import com.rt.generalframework.service.IDictIcdService;
import com.rt.pkgenerator.PKGeneratorCluster;
import org.springframework.stereotype.Service;

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
public class DictIcdServiceImpl extends ServiceImpl<DictIcdMapper, DictIcd> implements IDictIcdService {


    @Override
    public List<DictIcd> getIcdList() {
        return this.list();
    }

    @Override
    public boolean addIcd(DictIcd icd) {
        icd.setIcdCode(PKGeneratorCluster.nextPkStr());
        return this.save(icd);
    }

    @Override
    public boolean updateIcd(DictIcd icd) {
        QueryWrapper<DictIcd> query = Wrappers.query();
        query.eq(DictIcd.ICD_CODE, icd.getIcdCode());
        this.update(icd, query);
        return false;
    }
}
