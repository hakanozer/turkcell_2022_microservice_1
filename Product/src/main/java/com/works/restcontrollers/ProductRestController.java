package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestController {

    final ProductService pService;

    @Value("${baseDataUri}")
    private String baseDataUri;

    @GetMapping("/list")
    public String list() {
        return "Pull Data : " + baseDataUri;
    }


    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        return pService.save(product);
    }

}
