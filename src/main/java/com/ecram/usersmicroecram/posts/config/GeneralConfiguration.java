package com.ecram.usersmicroecram.posts.config;

import com.cloudinary.Cloudinary;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class GeneralConfiguration {

    @Value("${cloudinaryParams.cloudName}")
    private String cloudName;

    @Value("${cloudinaryParams.apiKey}")
    private String apiKey;

    @Value("${cloudinaryParams.apiSecret}")
    private String apiSecret;


    @Bean(name = "cloudinaryConfig")
    public Cloudinary cloudinaryConfig() {
        Cloudinary cloudinary = null;
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);
        cloudinary = new Cloudinary(config);
        return cloudinary;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
