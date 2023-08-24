package com.zijin.zijinapiinterface;

import com.zijin.zijinapiclientsdk.client.ZijinapiClient;
import com.zijin.zijinapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ZijinapiInterfaceApplicationTests {
	@Resource
	private ZijinapiClient zijinapiClient;
	@Test
	void contextLoads() {
		String zijin = zijinapiClient.getUsername("zijin");
		User user=new User();
		user.setUsername("yupi");
		String s = zijinapiClient.postUsernamebypost(user);
		System.out.println(zijin);
		System.out.println(s);
	}

}
