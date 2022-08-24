package com.works.restcontrollers;

import com.works.entities.Account;
import com.works.services.AcccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
@Slf4j
public class AccountRestController {

    final AcccountService aService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Account account) {
        if ( account.getEmail().equals("ali@mail.com") ) {
            //int end = 1 / 0;
        }
        return aService.login(account);
    }

}
