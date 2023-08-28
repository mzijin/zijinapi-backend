package com.zijin.zijinapiclientsdk.Utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * 签名工具，通过加密算法实现
 */
public class SignUtils {

    public static String getSign(String body, String secretKey){
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content=body+ "." + secretKey;
        return md5.digestHex(content);

    }
}
