package com.example.admin.fbnadmin;

import de.codecentric.boot.admin.notify.MailNotifier;
import org.springframework.context.ConfigurableApplicationContext;

public class FBN_Mail {

    private static final String DEFAULT_SUBJECT = "#{application.name} (#{application.id}) is #{to.status}";
    private static final String DEFAULT_TEXT = "#{application.name} (#{application.id})\nstatus changed from #{from.status} to #{to.status}\n\n#{application.healthUrl}";


    public static void init(ConfigurableApplicationContext context){
        MailNotifier mailNotifier=(MailNotifier) context.getBean("mailNotifier");


        mailNotifier.setSubject("SpringCloud中服务 #{application.name} 状态变更为 #{to.status}");
    }
}
