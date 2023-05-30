package com.app.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.app")
@EnableWebMvc
class SpringConfig implements WebMvcConfigurer {
    //private final ApplicationContext applicationContext;
//    @Bean
//    public ClassLoaderTemplateResolver secondaryTemplateResolver(){
//        ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
//        secondaryTemplateResolver.setPrefix("/WEB-INF/views/");
//        secondaryTemplateResolver.setSuffix(".html");
//        secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
//        secondaryTemplateResolver.setCharacterEncoding("UTF-8");
//        secondaryTemplateResolver.setOrder(1);
//        secondaryTemplateResolver.setCheckExistence(true);
//        return secondaryTemplateResolver;
//    }

//        }
//    @Override
//    public void addResourcesHandlers()
}