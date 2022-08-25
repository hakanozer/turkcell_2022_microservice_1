package com.works.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.ws.Response;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository pRepo;

    @HystrixCommand(fallbackMethod = "saveError")
    public ResponseEntity save(Product product) {
        int  end = 1 / 0;
        pRepo.save(product);
        return new ResponseEntity( product, HttpStatus.OK );
    }

    public ResponseEntity saveError( Product product ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", false);
        hm.put("message", "Save Error");
        return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity list() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", pRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
