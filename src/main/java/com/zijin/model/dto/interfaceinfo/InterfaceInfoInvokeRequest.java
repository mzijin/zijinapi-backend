package com.zijin.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**调用
 * 接口请求
 *
 * @TableName product
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 名称

    /**
     * 接口請求参数
     */
    private String userRequestParams;


    private static final long serialVersionUID = 1L;
}