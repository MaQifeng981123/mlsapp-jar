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
public class Message implements Serializable {


    private String msgId;

    private String msgData;

    private Date createDate;

    private String msgSendId;

    private String msgRecivceId;


    private String readed;
    public static final String READED = "readed";

    public static final String MSG_ID = "msg_id";

    public static final String MSG_DATA = "msg_data";

    public static final String CREATE_DATE = "CREATE_DATE";

    public static final String MSG_SEND_ID = "msg_send_id";

    public static final String MSG_RECIVCE_ID = "msg_recivce_id";

}
