package ${package.Controller};

import com.rt.generalframework.entity.${entity};
<#if entityLombokModel>
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
</#if>
import java.io.Serializable;
/**
* <p>
 *  数据传输对象
 * </p>
*
* @author ${author}
* @since ${date}
*/

<#if entityLombokModel>
@Data
 <#if superEntityClass??>
@EqualsAndHashCode(callSuper = true)
 <#else>
@EqualsAndHashCode(callSuper = false)
 </#if>
@Accessors(chain = true)
</#if>
public class ${entity}Dto extends ${entity} implements Serializable{

   <#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;
   </#if>

    private Integer pageSize;
    private Integer pageNo;

}
