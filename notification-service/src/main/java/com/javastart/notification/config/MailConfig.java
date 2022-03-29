package com.javastart.notification.config;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("classpath:mail-props.properties")
public class MailConfig {

    @Autowired
    private Environment enviroment;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smpt.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(enviroment.getProperty("mail.username"));
        mailSender.setPassword(enviroment.getProperty("mail.password"));

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol",
            enviroment.getProperty("mail.transport.protocol"));
        properties.put("mail.smtp.auth", enviroment.getProperty("mail.smtp.auth"));
        properties.put("mail.smtp.starttls.enable",
            enviroment.getProperty("mail.smtp.starttls.enable"));
        properties.put("mail.debug", enviroment.getProperty("mail.debug"));
        return mailSender;
    }

}
