package org.test.performance.infrastructure.database.entity;

import java.math.BigDecimal;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * Using PanacheEntityBase instead of PanacheEntity because a custom ID is needed
 * and because the repository pattern will be used. 
 */
@Entity
@Table(name = "account")
public class AccountEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "USER_ID")
    public String userId;
    public String account;
    public String name;
    public String number;
    public BigDecimal balance;
    public String currency;
    public String type;
    public String bank;

    public AccountEntity() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public AccountEntity(Integer id, String userId, String account, String name, String number, BigDecimal balance,
            String currency, String type, String bank) {
        this.id = id;
        this.userId = userId;
        this.account = account;
        this.name = name;
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.type = type;
        this.bank = bank;
    }

}
