package com.maocq.reactive.domain.model.account.gateways;

import com.maocq.reactive.domain.model.account.Account;
import reactor.core.publisher.Mono;

public interface AccountRepository {

    Mono<Account> findById(int id);
    Mono<Account> update(Account account);
}
