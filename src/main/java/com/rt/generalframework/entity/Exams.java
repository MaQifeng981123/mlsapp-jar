package com.rt.generalframework.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author ideaGenerator
* @since 2021-03-08
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Exams implements Serializable {


    private String examId;

    private String examData;

    private String createDate;

    private Date uploadDate;

    private String uploadFlag;

    private String userId;


        public static final String EXAM_ID = "exam_id";

        public static final String EXAM_DATA = "exam_data";

        public static final String CREATE_DATE = "CREATE_DATE";

        public static final String UPLOAD_DATE = "upload_date";

        public static final String UPLOAD_FLAG = "upload_flag";

        public static final String USER_ID = "user_id";

}
