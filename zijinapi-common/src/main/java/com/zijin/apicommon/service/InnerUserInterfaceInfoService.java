package com.zijin.apicommon.service;

import com.baomidou.mybatisplus.extension.service.IService;


/**
* @author cgy
* @description 针对表【user_interface_info(用户调用接口次数关系表)】的数据库操作Service
* @createDate 2023-08-25 12:43:16
*/
public interface InnerUserInterfaceInfoService {


    /**
     * 调用接口统计
     *]
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
