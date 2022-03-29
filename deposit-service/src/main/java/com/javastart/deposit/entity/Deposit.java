package com.javastart.deposit.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long depositId;

    private BigDecimal amount;

    private Long billId;

    private OffsetDateTime createDate;

    private String email;

    public Deposit(BigDecimal amount, Long billId, OffsetDateTime createDate, String email) {
        this.amount = amount;
        this.billId = billId;
        this.createDate = createDate;
        this.email = email;
    }
}
