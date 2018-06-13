package com.example.admin.fbnadmin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import de.codecentric.boot.admin.notify.MailNotifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan("com.*")
@EnableAdminServer
@SpringBootApplication
public class FbnAdminApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(FbnAdminApplication.class, args);

		//定制话预警邮件
		FBN_Mail.init(context);

	}
}
