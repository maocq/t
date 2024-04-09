package org.test.performance.infrastructure.database.repository;

import org.test.performance.domain.dao.account.AccountRepository;
import org.test.performance.domain.model.account.Account;
import org.test.performance.infrastructure.database.entity.AccountEntity;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

/*
 * Using the repository pattern. It may be useful to consider using the
 * Active Record pattern instead, in particular for greenfield
 * microservices / functions where the data model is usually simple and small;
 * since ActiveRecord is quicker and simpler to implement and maintain for simple models. 
 * For more information, refer to 
 * https://quarkus.io/guides/hibernate-reactive-panache#solution-1-using-the-active-record-pattern
 */
@ApplicationScoped
public class AccountRepositoryPanache implements AccountRepository, PanacheRepository<AccountEntity> {

    @Override
    @WithSession
    public Uni<Account> findById(int id) {
        return this.find("id", id).firstResult()
                .map(accountEntity -> accountEntity != null ? this.mapToAccount(accountEntity)
                        : null);
    }

    @Override
    @WithSession
    public Uni<Account> update(Account account) {
        return this.getSession()
                .chain(session -> session.merge(this.mapToAccountEntity(account)))
                .flatMap(accountEntity -> this.persistAndFlush(accountEntity))
                .map(this::mapToAccount);
    }

    private Account mapToAccount(AccountEntity accountEntity) {
        return new Account(accountEntity.id,
                accountEntity.userId,
                accountEntity.account,
                accountEntity.name,
                accountEntity.number,
                accountEntity.balance,
                accountEntity.currency,
                accountEntity.type,
                accountEntity.bank);
    }

    private AccountEntity mapToAccountEntity(Account account) {
        return new AccountEntity(account.id(),
                account.userId(),
                account.account(),
                account.name(),
                account.number(),
                account.balance(),
                account.currency(),
                account.type(),
                account.bank());

    }
}
