package com.dilarasevimpolat.Municipality.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dilarasevimpolat.Municipality.core.utilities.ImageService.ImageService;
import com.dilarasevimpolat.Municipality.core.utilities.ImageService.Cloudinary.CloudinaryImageManager;


@Configuration
public class AppConfiguration {
	
	@Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dozmwv4pa",
                "api_key", "644445282144435",
                "api_secret", "ZlxS2g3lGKb523tFMV8qLHf5jic"));
    }

    @Bean
    public ImageService imageService(){
        return new CloudinaryImageManager(cloudinaryService());
    }
	
}

