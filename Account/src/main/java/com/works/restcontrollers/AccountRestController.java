package com.works.restcontrollers;

import com.works.entities.Account;
import com.works.services.AcccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountRestController {

    final AcccountService aService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Account account) {
        return aService.login(account);
    }

}
