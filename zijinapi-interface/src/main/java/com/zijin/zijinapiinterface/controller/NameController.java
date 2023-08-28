package com.zijin.zijinapiinterface.controller;

import com.zijin.zijinapiclientsdk.Utils.SignUtils;
import com.zijin.zijinapiclientsdk.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/get")
    public String getUsername(String name , HttpServletRequest request){
        System.out.println(request.getHeader("yupi"));
        return "get user "+name;

    }
    @PostMapping("/post")
    public String postUsername(@RequestParam String name){
        return "post user"+name;
    }
    @PostMapping("/user")
    public String postUsernamebypost(@RequestBody User user, HttpServletRequest request){
//         String accessKey=request.getHeader("accessKey");
// //        千万不要在后端传递，不安全
// //        String secretKey=request.getHeader("secretKey");
//         String body=request.getHeader("body");
//         String sign=request.getHeader("sign");
//         String nonce=request.getHeader("nonce");
//         //签名校验
//         if(!accessKey.equals("xiaochen")){
//             throw new RuntimeException("无权限");
//         }
//         if(Long.parseLong(nonce) > 10000){
//             throw new RuntimeException("无权限");
//         }
//         String serversign = SignUtils.getSign(body, "abcdef");
//         if(!sign.equals(serversign)){
//             throw new RuntimeException("无权限");
//         }

        String result= "post你的名字是"+user.getUsername();
        return result;
    }
}
