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
public class DictUsers implements Serializable {


    private String userId;

    private String name;

    private String loginId;

    private String password;

    private String staffType;

    private String introduce;

    private String phoneNumber;

    private Date createDate;

    private String icdCodes;

    private String icdNames;




    public static final String USER_ID = "user_id";

    public static final String NAME = "name";

    public static final String LOGIN_ID = "LOGIN_ID";

    public static final String PASSWORD = "PASSWORD";

    public static final String STAFF_TYPE = "STAFF_TYPE";

    public static final String INTRODUCE = "INTRODUCE";

    public static final String PHONE_NUMBER = "PHONE_NUMBER";

    public static final String CREATE_DATE = "CREATE_DATE";

    public static final String ICD_CODES = "ICD_CODES";

    public static final String ICD_NAMES = "ICD_NAMES";

}
