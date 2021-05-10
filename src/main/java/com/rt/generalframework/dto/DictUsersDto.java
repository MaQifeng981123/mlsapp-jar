package com.rt.generalframework.dto;

import com.rt.generalframework.entity.DictUsers;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 数据传输对象
 * </p>
 *
 * @author ideaGenerator
 * @since 2021-03-08
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictUsersDto extends DictUsers implements Serializable {

    private String lastMsgContent;

    private Date lastMsgDate;

    private int unReadMsgCount;
    private Integer pageSize;
    private Integer pageNo;

}
