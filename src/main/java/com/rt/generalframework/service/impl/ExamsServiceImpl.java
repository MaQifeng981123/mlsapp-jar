package com.rt.generalframework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rt.generalframework.entity.ExamData;
import com.rt.generalframework.entity.Exams;
import com.rt.generalframework.mapper.ExamsMapper;
import com.rt.generalframework.service.IExamsService;
import com.rt.global.JsonResult;
import com.rt.global.JsonResultUtil;
import com.rt.json.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ideaGenerator
 * @since 2021-03-08
 */
@Service()
public class ExamsServiceImpl extends ServiceImpl<ExamsMapper, Exams> implements IExamsService {

    @Autowired
    ExamsMapper examsMapper;

    @Override
    public boolean saveExam(Exams e) {
        return this.save(e);
    }

    @Override
    public boolean updateExam(Exams e) {
        return examsMapper.updateExamFlag(e);
    }

    @Override
    public List<Exams> getExamList(Exams e) {
        QueryWrapper<Exams> query = Wrappers.query();
        String userId = e.getUserId();
        if (userId != null) {
            query.eq(Exams.USER_ID, userId);
        }
        if (e.getCreateDate() != null) {
            query.eq(Exams.CREATE_DATE, e.getCreateDate());
        }
        return this.list(query);
    }

    @Override
    public JsonResult getStatistics(Exams e) {
        List<Exams> statistics = examsMapper.getStatistics(e);
        List<Map<String, List>> result = new ArrayList<>(10);
        if (!CollectionUtils.isEmpty(statistics)) {
            Map<String, List> map = new HashMap<>(7);
            List<Double> v1 = new ArrayList<>();
            List<Double> v2 = new ArrayList<>();
            List<Double> v3 = new ArrayList<>();
            List<Double> v4 = new ArrayList<>();
            List<Double> v5 = new ArrayList<>();
            List<Double> v6 = new ArrayList<>();
            List<String> v7 = new ArrayList<>();
            for (Exams exams : statistics) {
                String examDataStr = exams.getExamData();
                ExamData examData = JsonUtil.json2Bean(examDataStr, ExamData.class);
                if (examData != null) {
                    v1.add(examData.getFhl());
                    v2.add(examData.getKfxt());
                    v3.add(examData.getSg());
                    v4.add(examData.getTw());
                    v5.add(examData.getTz());
                    v6.add(examData.getXy());
                    v7.add(exams.getCreateDate());
                }
            }
            map.put("fhl", v1);
            map.put("kfxt", v2);
            map.put("sg", v3);
            map.put("tw", v4);
            map.put("tz", v5);
            map.put("xy", v6);
            map.put("createDate", v7);
            result.add(map);
        }
        return JsonResultUtil.success(result);
    }
}
