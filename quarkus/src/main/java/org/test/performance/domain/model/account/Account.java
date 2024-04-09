package org.test.performance.domain.model.account;

import java.math.BigDecimal;

import lombok.Builder;

/*
 * Using the Lombok Builder annotation in this record merely
 * to show that Lombok can be used with Quarkus. The use of lombok
 * should be carefully considered, since it can compromise class readability
 */
@Builder(toBuilder = true)
public record Account(
                Integer id, String userId, String account, String name, String number, BigDecimal balance,
                String currency, String type, String bank) {

}
