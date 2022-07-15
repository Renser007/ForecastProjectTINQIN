package com.example.startingproject.domain.interfaces;

import org.springframework.web.client.RestTemplate;

public interface RestTemplateProvider {

     RestTemplate getRestTemplate();

}
