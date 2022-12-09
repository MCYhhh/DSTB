package com.example.ty.config;

import com.example.ty.config.interceptor.JwtInterceptorWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfigWorker implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptorWorker()) //注册拦截器
//        .excludePathPatterns("/**");
                .addPathPatterns("/**") //拦截一切请求(任何请求路径)
                .excludePathPatterns("/user/login","/worker/login","/user/register");//放过login登录请求和worker的请求
//        registry.addInterceptor(jwtInterceptorWorker())
//                .addPathPatterns("/**")  // ������������ͨ���ж�token�Ƿ�Ϸ��������Ƿ���Ҫ��¼
//                .excludePathPatterns("/user/login","/worker/login", "/user/register", "/**/export", "/**/import", "/file/**"
//                       , "/webjars/**", "/v2/**", "/api", "/api-docs", "/api-docs/**")//���е�¼ע�ᣬ���뵼���ȹ���
//               .excludePathPatterns("/**/*.html", "/**/*.js", "/**/*.css", "/**/*.woff", "/**/*.ttf");  // ���о�̬�ļ�

    }

    @Bean
    public JwtInterceptorWorker jwtInterceptorWorker(){
        return new JwtInterceptorWorker();
    }

}
