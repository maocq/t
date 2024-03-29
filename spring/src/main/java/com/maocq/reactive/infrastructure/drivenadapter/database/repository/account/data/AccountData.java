package com.maocq.reactive.infrastructure.drivenadapter.database.repository.account.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("account")
public class AccountData {
    @Id
    private Integer id;
    private String userId;
    private String account;
    private String name;
    private String number;
    private BigDecimal balance;
    private String currency;
    private String type;
    private String bank;
}
