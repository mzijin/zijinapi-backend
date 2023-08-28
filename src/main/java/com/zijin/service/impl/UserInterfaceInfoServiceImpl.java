package com.zijin.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zijin.apicommon.model.entity.UserInterfaceInfo;
import com.zijin.common.ErrorCode;
import com.zijin.exception.BusinessException;
import com.zijin.mapper.UserInterfaceInfoMapper;

import com.zijin.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public  class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，所有参数必须非空
        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId()<=0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"接口或者用户不存在");
            }
        }
        if (userInterfaceInfo.getLeftnum()<0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "最小次数不得小于0");
        }
    }

    /**
     * 统计调用次数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        if(interfaceInfoId<=0 || userId<=0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);

        }
        //使用Wrapper操作数据库,这段代码的sql书写
        //update user_interface_info set leftnum=leftnum-1,totalnum=totalnum+1
        //                            where interfaceInfoId=1 and  userId=1;

        UpdateWrapper<UserInterfaceInfo> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId",interfaceInfoId);
        updateWrapper.eq("userId",userId);
        //必须大于0
        updateWrapper.gt("leftnum",0);
        updateWrapper.setSql("leftnum=leftnum-1, totalnum= totalnum+1");
        return this.update(updateWrapper);
    }


}




