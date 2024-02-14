package com.maocq.reactive.domain.usecase;

import com.maocq.reactive.domain.model.account.Account;
import com.maocq.reactive.domain.model.account.gateways.AccountRepository;
import com.maocq.reactive.domain.model.primes.Primes;
import com.maocq.reactive.domain.model.user.User;
import com.maocq.reactive.domain.model.user.gateways.UserGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class ScenariosUseCase {

    private final AccountRepository accountRepository;
    private final UserGateway userGateway;

    public Mono<User> caseOne(int latency) {
        return userGateway.get(latency);
    }

    public Mono<String> caseTwo(int number) {
        return Mono.just(Primes.primes(number));
    }

    public Mono<Account> caseThree(int id) {
        return accountRepository.findById(id);
    }

    public Mono<Account> caseFour(int id, int latency) {
        return accountRepository.findById(id)
                .flatMap(account -> userGateway.get(latency)
                .flatMap(user -> {
                    var newAccount = account
                            .toBuilder()
                            .userId(user.id())
                            .build();
                    return accountRepository.update(newAccount);
                }));
    }
}
