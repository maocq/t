package org.test.performance.domain.business.usecase;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.test.performance.domain.business.primes.Primes;
import org.test.performance.domain.dao.account.AccountRepository;
import org.test.performance.domain.model.account.Account;
import org.test.performance.domain.model.user.User;
import org.test.performance.infrastructure.restconsumer.UserServiceClient;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UseCaseService {

    @RestClient
    @Inject
    UserServiceClient userServiceClient;

    @Inject
    AccountRepository accountRepository;

    public Uni<User> caseOne(Integer latency) {
        return this.userServiceClient.getUser(latency);
    }

    public Uni<String> caseTwo(Integer number) {

        /*
         * Have the value be retrieved lazily at subscription time
         * and release the I/O thread if it blocks.
         * For more information, see
         * https://smallrye.io/smallrye-mutiny/1.6.0/guides/imperative-to-reactive/
         */
        return Uni.createFrom().item(() -> Primes.primes(number));
    }

    public Uni<Account> caseThree(int id) {
        return this.accountRepository.findById(id);

    }

    public Uni<Account> caseFour(int id, int latency) {
        return this.accountRepository.findById(id)
                .flatMap(account -> this.userServiceClient.getUser(latency)
                        .flatMap(user -> this.accountRepository.update(account.toBuilder()
                                .userId(user.id()).build())))

        ;
    }

}
