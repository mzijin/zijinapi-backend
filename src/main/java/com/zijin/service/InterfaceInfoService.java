package com.zijin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zijin.model.entity.InterfaceInfo;

/**
 *
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
