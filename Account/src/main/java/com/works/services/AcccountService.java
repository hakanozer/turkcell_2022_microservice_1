package com.works.services;

import com.works.entities.Account;
import com.works.repositoies.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcccountService {

    final AccountRepository aRepo;

    public ResponseEntity login(Account account) {
       Optional<Account> optionalAccount = aRepo.findByEmailEqualsIgnoreCaseAndPasswordEquals(account.getEmail(), account.getPassword());
       return new ResponseEntity(optionalAccount.get(), HttpStatus.OK);
    }

}
