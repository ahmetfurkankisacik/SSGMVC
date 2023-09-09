package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xml yerine kullanmamizi saglar
//dispatcher servletin tanimlanmasi
//configuraiton classlarinin yerini gostermek
//bu iki işlem icin : AbstractAnnotationConfigDispatcherServletInitializer;
public class WebAppInitalizer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override//db ve hibernate ile ilgili configurasyonlar
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                RootContextConfig.class
        };
    }

    @Override//MVC config ayarlari icin : bean tanimlamalarinin yer aldigi class
    protected Class<?>[] getServletConfigClasses() {

        return new Class[]{
                WebMvcConfig.class
        };
    }
    //http://localhost:8080/SSGMVC

    @Override//hangi url servelt ile iliskilendirildigi
    protected String[] getServletMappings() {
        return new String[]{"/"};

    }
}
