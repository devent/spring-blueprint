package com.anrisoftware.timefractalweb.web.core.internal.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.anrisoftware.timefractalweb.web.internal.controller" })
public class WebConfig implements WebMvcConfigurer {
    // ...
}
