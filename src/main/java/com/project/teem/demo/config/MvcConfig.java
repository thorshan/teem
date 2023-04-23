package com.project.teem.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/");
        Path productUploadDir= Paths.get("src/main/resources/product-photos");
        String productUploadPath=productUploadDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/product-photos/**").addResourceLocations("file:/"+productUploadPath+"/");
    }

}
