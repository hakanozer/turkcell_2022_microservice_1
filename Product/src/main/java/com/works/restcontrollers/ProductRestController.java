package com.works.restcontrollers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/product")
public class ProductRestController {

    @Value("${baseDataUri}")
    private String baseDataUri;

    @GetMapping("/list")
    public String list() {
        return "Pull Data : " + baseDataUri;
    }


}
