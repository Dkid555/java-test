package com.app.main;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.app")
//@PropertySource("classpath:src/main/resources/application.properties")
//@EnableWebMvc
class SpringConfig implements WebMvcConfigurer {
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofBytes(512000000L));
        factory.setMaxRequestSize(DataSize.ofBytes(512000000L));
        return factory.createMultipartConfig();
    }
//    @Autowired
//    Environment env;
//    @Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("resources/**").addResourceLocations("resources/");
//    }
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
//    public void addResourcesHandlers

//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        // Css resource.
//        registry.addResourceHandler("/resources/**") //
//                .addResourceLocations("/resources/").setCachePeriod(31556926);
//
//    }
}
