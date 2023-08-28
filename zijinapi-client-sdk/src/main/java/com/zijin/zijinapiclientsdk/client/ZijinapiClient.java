package com.zijin.zijinapiclientsdk.client;


import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.zijin.zijinapiclientsdk.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.zijin.zijinapiclientsdk.Utils.SignUtils.getSign;


/**
 * 调用接口的客户端
 * @author zijin
 */
public class ZijinapiClient {
    private static final String GATEWAY_HOST="http://localhost:8090";
    private String accessKey;
    private String secretKey;

    public ZijinapiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getUsername(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.get(GATEWAY_HOST+"/api/name", paramMap);
        System.out.println(result);
        return  result;
    }
    public String postUsername(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result= HttpUtil.post(GATEWAY_HOST+"/api/name", paramMap);
        System.out.println(result);
        return  result;

    }



    private Map<String, String> getHeaderMap(String body){
        Map<String,String> hashMap=new HashMap<>();
        hashMap.put("accessKey",accessKey);
        //        千万不要在后端传递，不安全
//        hashMap.put("secretKey",secretKey);
//        生成随=随机数
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
//
        hashMap.put("body",body);
//        时间戳
        hashMap.put("timestamp",String.valueOf(System.currentTimeMillis() / 1000));
//        签名
        hashMap.put("sign",getSign(body,secretKey));
        return hashMap;
    }


    public String postUsernamebypost( User user){
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST+"/api/name/user/")
//                模拟签名认证，增加一个请求头，在上面写一个写一个请求头接口，当请求头里的内容与contrller成类的信息对的上，就给返回数据
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
//        获取状态码，查看是否成功
        System.out.println(httpResponse.getStatus());
        String result=httpResponse.body();
        System.out.println(result);
        return result;
    }
}
