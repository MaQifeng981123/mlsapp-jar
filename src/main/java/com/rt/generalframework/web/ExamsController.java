package com.rt.generalframework.web;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import com.rt.generalframework.entity.ExamData;
import com.rt.generalframework.entity.Exams;
import com.rt.generalframework.service.IExamsService;
import com.rt.generalframework.service.impl.ExamsServiceImpl;
import com.rt.global.JsonResult;
import com.rt.global.JsonResultUtil;
import com.rt.json.util.JsonUtil;
import com.rt.pkgenerator.PKGeneratorCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/exam")
public class ExamsController {

    @Autowired
    private IExamsService examsService;


    /*/**
     * 模拟数据收集： 对健康指标进行随机数获取 （Simulation data collection: Random number acquisition of health indicators）
     */
    private ExamData getrdExamData() {
        ExamData data = new ExamData();
        //体重（weight）
        data.setTz(NumberUtil.generateRandomNumber(700, 710, 1)[0] / 10);
        //空腹血糖: 3.9-6.1mmol/L
        data.setKfxt(NumberUtil.generateRandomNumber(30, 70, 1)[0] / 10);
        // 身高（height）
        data.setSg(170);
        //心率 （Heart rate） 60-100
        data.setXl(NumberUtil.generateRandomNumber(50, 120, 1)[0]);
        //血压（blood pressure） >140
        data.setXy(NumberUtil.generateRandomNumber(110, 150, 1)[0]);
        //腰围（waistline）
        data.setYw(732);
        //体温（temperature） 36-39
        data.setTw(NumberUtil.generateRandomNumber(360, 390, 1)[0] / 10);
        //肺活量（Vital capacity） 3200-3800
        data.setFhl(NumberUtil.generateRandomNumber(3200, 3800, 1)[0]);
        return data;
    }

    // Get data of the day
    @PostMapping("/createCurrExamData")
    public JsonResult createCurrExamData(String userId) {
        Exams exams = new Exams();
        exams.setUserId(userId);
        exams.setCreateDate(DateUtil.formatDate(new Date()));
        exams.setUploadFlag("1");
        List<Exams> examList = examsService.getExamList(exams);
        if (!CollectionUtils.isEmpty(examList)) {
            exams = examList.get(0);
        } else {
            ExamData data = this.getrdExamData();
            exams.setExamId(PKGeneratorCluster.nextPkStr());
            exams.setExamData(JsonUtil.toJson(data));
            exams.setUserId(userId);
            exams.setUploadFlag("0");
            examsService.saveExam(exams);
        }
        return JsonResultUtil.success(exams);
    }

    // insert data
    @PostMapping("/addExamData")
    public JsonResult addExamData(ExamData data, String userId) {
        Exams exams = new Exams();
        exams.setCreateDate(DateUtil.formatDate(new Date()));
        exams.setExamId(PKGeneratorCluster.nextPkStr());
        exams.setExamData(JsonUtil.toJson(data));
        exams.setUserId(userId);
        examsService.saveExam(exams);
        return JsonResultUtil.success(exams);
    }

    // update data
    @PostMapping("/uploadExamData")
    public JsonResult uploadExamData(Exams exams) {
        examsService.updateExam(exams);
        return JsonResultUtil.success();
    }

    // get  data list
    @PostMapping("/getExamDataList")
    public JsonResult getExamDataList(String userId) {
        Exams exams = new Exams();
        exams.setUserId(userId);
        return JsonResultUtil.success(examsService.getExamList(exams));
    }


    @PostMapping("/getStatistics")
    public JsonResult getStatistics(String userId) {
        Exams exams = new Exams();
        exams.setUserId(userId);
        return examsService.getStatistics(exams);
    }


}
