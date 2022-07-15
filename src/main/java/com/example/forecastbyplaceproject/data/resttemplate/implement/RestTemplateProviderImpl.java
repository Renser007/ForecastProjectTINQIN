package com.example.forecastbyplaceproject.data.resttemplate.implement;

import com.example.forecastbyplaceproject.data.resttemplate.provider.RestTemplateProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateProviderImpl implements RestTemplateProvider {

    public RestTemplateProviderImpl() {

        System.out.println("Created RestTemplateProviderImpl");

    }

    @Override
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
