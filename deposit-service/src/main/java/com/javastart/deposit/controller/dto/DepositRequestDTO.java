package com.javastart.deposit.controller.dto;


import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepositRequestDTO {

    private Long accountId;

    private Long billId;

    private BigDecimal amount;
}
