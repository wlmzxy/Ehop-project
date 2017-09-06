package org.lanqiao.util;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class MailUtil {
	//邮箱服务器的端口地址
	static final String smtp_Host="smtp.qq.com";
	//发送者的邮箱授权码
	static final String auth_password="sevanzuycxdvebbb";
	//发送邮件的账号
	static final String from="2607676065@qq.com";
	public static void sendMail(String mailAddress,String subject,String content){
		
		//建立与邮箱的服务器的会话
		Properties properties=new Properties();
		//设置邮件服务器的端口地址
		properties.setProperty("mail.smtp.host", smtp_Host);
		//设置发送邮件的协议
		properties.setProperty("mail.transport.protocol", "smtp");
		//设置验证
		properties.setProperty("mail.smtp.auth", "true");
		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, auth_password);//客户端授权密码
					}
				};
		Session session=Session.getDefaultInstance(properties);
		//qq邮箱开启ssl认证
		MailSSLSocketFactory sf=null;
				try {
					sf = new MailSSLSocketFactory();
			} catch (GeneralSecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sf); 
				
		//创建邮件
		MimeMessage message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from, "小明", "utf-8"));
			//设置邮件主题
			message.setSubject(subject);
			//设置发送日期
			message.setSentDate(new Date());
			//设置邮件内容
			message.setContent(content, "text/html;charset=utf-8");
			//设置收件人
			//to:收件人  bcc：密送   cc：抄送
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mailAddress,"xxx","utf-8"));
			//发送邮件
			//创建发送邮件的对象
			Transport transport=session.getTransport();
			//通过授权码以发送人的身份链接邮箱服务器
			transport.connect(from, auth_password);
			//发送邮件
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		
		} catch (UnsupportedEncodingException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
