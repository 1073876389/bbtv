package com.xuwenxing.bbtv.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;

/**
 * Created by xuwx on 2018/8/14.
 */
@Configuration
public class DruidConfiguration {
    @Bean
    public ServletRegistrationBean druidServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        HashMap<String, String> initParameters = new HashMap<>();
        //用户名
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");
        //禁用html页面上的 reaet all 功能
        initParameters.put("resetEnable","false");
        //IP白名单("不配置为空,则永续所有访问")
        initParameters.put("allow","");
        //IP黑名单(与白名单共同存在时,deny优先于allow)
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,");
        return filterRegistrationBean;
    }
}
