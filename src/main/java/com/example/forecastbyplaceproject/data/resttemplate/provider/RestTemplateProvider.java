package com.example.forecastbyplaceproject.data.resttemplate.provider;

import org.springframework.web.client.RestTemplate;

public interface RestTemplateProvider {

    RestTemplate getRestTemplate();

}
