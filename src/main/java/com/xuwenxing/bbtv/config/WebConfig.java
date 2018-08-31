package com.xuwenxing.bbtv.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by xuwx on 2018/8/20.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    //    @Value("${spring.mvc.view.prefix}")
//    private String prefix;
//
//    @Value("${spring.mvc.view.suffix}")
//    private String suffix;
//
//    @Value("${spring.mvc.view.view-name}")
//    private String viewNames;
//
//    @Value("${spring.mvc.view.order}")
//    private int order;
//
//    @Bean
//    InternalResourceViewResolver jspViewResolver(){
//       final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//       viewResolver.setPrefix(prefix);
//       viewResolver.setSuffix(suffix);
//       viewResolver.setViewNames(viewNames);
//       viewResolver.setOrder(order);
//       return  viewResolver;
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/webSocket").setViewName("/webSocket");
    }
}
