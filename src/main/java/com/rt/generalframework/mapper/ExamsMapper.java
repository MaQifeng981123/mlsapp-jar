package com.rt.generalframework.mapper;

import com.rt.generalframework.entity.Exams;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ideaGenerator
 * @since 2021-03-08
 */
public interface ExamsMapper extends BaseMapper<Exams> {


    List<Exams> getStatistics(Exams e);

    boolean updateExamFlag(Exams e);
}
