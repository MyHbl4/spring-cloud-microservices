package com.javastart.deposit.controller.dto;


import com.javastart.deposit.entity.Deposit;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepositResponseDTO {

    private BigDecimal amount;

    private String email;

    public DepositResponseDTO(Deposit deposit) {
        this.amount = deposit.getAmount();
        this.email = deposit.getEmail();
    }
}