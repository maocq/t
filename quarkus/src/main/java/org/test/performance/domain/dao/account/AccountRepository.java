package org.test.performance.domain.dao.account;

import org.test.performance.domain.model.account.Account;

import io.smallrye.mutiny.Uni;

public interface AccountRepository {
    public abstract Uni<Account> findById(int id);

    public abstract Uni<Account> update(Account account);
}
