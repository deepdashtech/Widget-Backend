package com.example.Widget.in.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Map /widget-icons/** URLs to your local folder
        registry.addResourceHandler("/widget-icons/**")
                .addResourceLocations(
                        "file:C:/Users/KrishnangThakkar/OneDrive - Dash Technologies Inc/Desktop/java/Widget-Backend/src/main/resources/uploads/widgets/icons/"
                );

    }
}
