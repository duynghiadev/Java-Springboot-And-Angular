package com.project.shopapp.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;

public class LanguageConfig {
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n.messages"); // Tên cơ sở của các tệp tài liệu ngôn ngữ
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}