package com.works.repositoies;

import com.works.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByEmailEqualsIgnoreCaseAndPasswordEquals(String email, String password);

}