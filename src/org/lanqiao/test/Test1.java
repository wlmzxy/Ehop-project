package org.lanqiao.test;

import org.junit.Test;
import org.lanqiao.util.MailUtil;
import org.lanqiao.util.Md5Util;

public class Test1 {
	@Test
	public void testsendMail(){
	MailUtil.sendMail("2143283268@qq.com", "验证信息", "单击此链接以完成注册");
}
	@Test
	public void testMd5(){
		System.out.println(Md5Util.md5("123456"));
	}
}
