package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc//mvc yapısında calisicak
@ComponentScan("com.tpe")//taranip bean olusturulmasi saglar
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);//daha az kod yazarak jsp dosyalarini goruntuluyoruz
        resolver.setPrefix("/WEB-INF/views/");//bu dosyalarin nerde oldugunu gosterir
        resolver.setSuffix(".jsp");//uzatinini ne oldugunu gosterir
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {//
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(0);
    }
}
