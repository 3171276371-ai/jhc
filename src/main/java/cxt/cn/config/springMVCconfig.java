package cxt.cn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @创建人 ： 陈啸掭
 * @创建时间 ： 2019/11/7
 * @描述
 */
@Configuration
public class springMVCconfig extends WebMvcConfigurerAdapter{
    @Bean
     public WebMvcConfigurerAdapter WebMvcConfigurer(){
         WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter(){
             @Override
             public void addViewControllers(ViewControllerRegistry registry) {
                 registry.addViewController("/register.html").setViewName("register");
                 registry.addViewController("/").setViewName("login");
                 registry.addViewController("/login.html").setViewName("login");
                 registry.addViewController("/index.html").setViewName("index");
                 registry.addViewController("/updatePassword.html").setViewName("updatePassword");
                 registry.addViewController("/games1.html").setViewName("games1");
             }

             @Override
             public void addInterceptors(InterceptorRegistry registry) {
                 registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/templates/**").excludePathPatterns("/login.html","/register.html");
             }
         };

         return webMvcConfigurerAdapter;

     }
}
