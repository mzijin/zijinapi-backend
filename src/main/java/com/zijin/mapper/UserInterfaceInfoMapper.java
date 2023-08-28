package com.zijin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zijin.apicommon.model.entity.UserInterfaceInfo;

import java.util.List;


public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




