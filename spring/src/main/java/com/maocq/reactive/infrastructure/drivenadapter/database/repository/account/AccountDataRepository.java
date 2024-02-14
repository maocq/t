package com.maocq.reactive.infrastructure.drivenadapter.database.repository.account;

import com.maocq.reactive.domain.model.account.Account;
import com.maocq.reactive.domain.model.account.gateways.AccountRepository;
import com.maocq.reactive.infrastructure.drivenadapter.database.repository.account.data.AccountData;
import com.maocq.reactive.infrastructure.drivenadapter.database.repository.account.data.AccountDataDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
@RegisterReflectionForBinding(Account.class)
public class AccountDataRepository implements AccountRepository {

    private final AccountDataDAO accountDataDAO;

    @Override
    public Mono<Account> findById(int id) {
        return accountDataDAO.findById(id)
                .map(this::toEntity);
    }

    @Override
    public Mono<Account> update(Account account) {
        return accountDataDAO.save(toData(account))
                .map(this::toEntity);
    }

    private Account toEntity(AccountData data) {
        return new Account(data.getId(), data.getUserId(), data.getAccount(), data.getName(),
                data.getNumber(), data.getBalance(), data.getCurrency(), data.getType(), data.getBank());
    }

    private AccountData toData(Account data) {
        return new AccountData(data.id(), data.userId(), data.account(), data.name(), data.number(), data.balance(),
                data.currency(), data.type(), data.bank());
    }
}
