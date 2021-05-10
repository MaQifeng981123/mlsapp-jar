package com.rt.generalframework.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 周扬
 * @version V1.0
 * @ClassName: ExamData
 * @Description: 类说明
 * @Copyright: Copyright (c) 2018
 * @company TODO广州易联众睿图信息技术有限公司
 * @date 2021/3/8
 */
@Data
public class ExamData implements Serializable {

    //空腹血糖
    private double kfxt;

    //体重
    private double tz;

    //身高
    private double sg;

    //腰围
    private double yw;

    //血压
    private double xy;

    //心率
    private double xl;

    //心率
    private double xz;

    // 体温
    private double tw;
    //肺活量
    private double fhl;

}
