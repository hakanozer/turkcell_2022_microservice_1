package com.works.services;

import com.works.entities.Account;
import com.works.ifeign.IProduct;
import com.works.ifeign.JsonPlace;
import com.works.props.JsonProduct;
import com.works.repositoies.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@Slf4j
public class AcccountService {

    final AccountRepository aRepo;
    final DiscoveryClient discoveryClient;
    final IProduct iProduct;
    final JsonPlace jsonPlace;

    public ResponseEntity login(Account account) {
       Optional<Account> optionalAccount = aRepo.findByEmailEqualsIgnoreCaseAndPasswordEquals(account.getEmail(), account.getPassword());
       Map<String, Object> hm = new LinkedHashMap<>();
       if (optionalAccount.isPresent() ) {
           hm.put("account", optionalAccount.get());
       }
       List<ServiceInstance> ls = discoveryClient.getInstances("Product-Service");
       if ( !ls.isEmpty() && ls.size() > 0 ) {
           String url = ls.get(0).getUri().toString();
           RestTemplate restTemplate = new RestTemplate();
           JsonProduct obj = restTemplate.getForObject(url+"/product/list", JsonProduct.class);
           hm.put("product", obj.getResult());
       }

       JsonProduct jsonProduct = iProduct.jsonList();
       hm.put("productFeign", iProduct.jsonList() );
       //log.info("info product", jsonProduct.toString());
        hm.put("users", jsonPlace.users() );
       return new ResponseEntity(hm, HttpStatus.OK);
    }

}
