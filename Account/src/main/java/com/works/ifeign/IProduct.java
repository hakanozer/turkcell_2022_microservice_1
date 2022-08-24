package com.works.ifeign;

import com.works.props.JsonProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "Product-Service")
public interface IProduct {

    @GetMapping("/product/list")
    JsonProduct jsonList();

}
