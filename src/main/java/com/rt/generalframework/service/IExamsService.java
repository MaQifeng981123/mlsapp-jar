package com.rt.generalframework.service;

import com.rt.generalframework.entity.Exams;
import com.rt.global.JsonResult;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ideaGenerator
 * @since 2021-03-08
 */
public interface IExamsService {

    boolean saveExam(Exams e);

    boolean updateExam(Exams e);

    List<Exams> getExamList(Exams e);

    JsonResult getStatistics(Exams e);
}
