package com.works.ifeign;

import com.works.props.JsonUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "A-Service", url = "https://jsonplaceholder.typicode.com")
public interface JsonPlace {

    @GetMapping("/users")
    List<JsonUser> users();

}
