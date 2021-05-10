package com.rt.generalframework.entity;

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
public class DictIcd implements Serializable {


    private String icdCode;

    private String icdName;

    private String introduce;


        public static final String ICD_CODE = "ICD_CODE";

        public static final String ICD_NAME = "ICD_NAME";

        public static final String INTRODUCE = "INTRODUCE";

}
