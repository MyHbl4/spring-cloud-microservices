package com.javastart.notification.service;


import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepositResponseDTO {

    private BigDecimal amount;

    private String mail;
}
