//package com.Full.Full.Stack.App;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class FullStackAppApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(FullStackAppApplication.class, args);
//    }
//}
package com.Full.Full.Stack.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FullStackAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullStackAppApplication.class, args);
    }

    @Configuration
    @EnableWebMvc
    public class CorsConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:4200")  // Replace with your Angular frontend URL
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("*")
                    .allowCredentials(true);

        }
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/images/**")
                    .addResourceLocations("classpath:/static/images/");
        }
    }
}
