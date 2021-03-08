package com.spireon.footballleague.setting;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class FeignClientConfig {


        @Bean
        public Decoder feignDecoder() {
            HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
            ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
            return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
        }

        public ObjectMapper customObjectMapper(){
            ObjectMapper objectMapper = new ObjectMapper();
            //Customize as much as you want
            objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            return objectMapper;
        }

}
