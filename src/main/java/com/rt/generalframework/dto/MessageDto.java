package com.rt.generalframework.dto;

import com.rt.generalframework.entity.Message;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;
/**
* <p>
 *  数据传输对象
 * </p>
*
* @author ideaGenerator
* @since 2021-03-08
*/

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MessageDto extends Message implements Serializable{


    private Integer pageSize;
    private Integer pageNo;

}
