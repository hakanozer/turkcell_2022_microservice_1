package com.works.restcontrollers;

import com.google.gson.Gson;
import com.works.entities.Product;
import com.works.props.SendData;
import com.works.services.ProductService;
import com.works.utils.TinkEncDec;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestController {

    final ProductService pService;
    final JmsTemplate jmsTemplate;

    @Value("${baseDataUri}")
    private String baseDataUri;

    //@GetMapping("/list")
    //public String list() {
       // return "Pull Data : " + baseDataUri;
    //}


    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        return pService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        SendData sendData = new SendData();
        sendData.setService("product-service");
        Map<String, String > hm = new LinkedHashMap<>();
        hm.put("status", "ok");
        hm.put("id", "100");
        sendData.setResult(hm);
        Gson gson = new Gson();
        String jsonString = gson.toJson(sendData);
        jsonString =  new TinkEncDec().encrypt( jsonString );
        jmsTemplate.convertAndSend(jsonString);
        return pService.list();
    }

}
