package com.works.config;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        switch ( response.status() ) {
            case 400:
                return new RuntimeException("400 Status");
            case 404:
                System.out.println("404 Status Error");
                return new FeignException.NotFound(s, null, null,null);
        }
        return null;
    }

}
