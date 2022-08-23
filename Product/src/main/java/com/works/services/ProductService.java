package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository pRepo;

    public ResponseEntity save(Product product) {
        pRepo.save(product);
        return new ResponseEntity( product, HttpStatus.OK );
    }

}
