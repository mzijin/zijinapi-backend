package com.zijin.apicommon.service;


import com.zijin.apicommon.model.entity.User;

/**
 * 用户服务
 *
 * @author yupi
 */
public interface InnerUserService {
    /**
     * 数据库中查是否已分配给用户ak ,sk
     *
     */
      User getInvokeUser(String accessKey);


}
