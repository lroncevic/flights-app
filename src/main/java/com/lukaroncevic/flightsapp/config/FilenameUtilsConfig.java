package com.lukaroncevic.flightsapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import util.FilenameUtils;

@Configuration
public class FilenameUtilsConfig {

    @Bean
    public FilenameUtils getFilenameUtils(){
        return new FilenameUtils();
    }
}
