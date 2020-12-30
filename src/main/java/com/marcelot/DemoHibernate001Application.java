package com.marcelot;

import java.awt.image.BufferedImage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootApplication
public class DemoHibernate001Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoHibernate001Application.class, args);
	}
	
    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }

}
