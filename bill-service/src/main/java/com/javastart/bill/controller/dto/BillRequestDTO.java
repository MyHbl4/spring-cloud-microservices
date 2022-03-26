package com.javastart.bill.controller.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.Getter;

@Getter
public class BillRequestDTO {

    private Long accountId;

    private BigDecimal amount;

    private Boolean isDefault;

    private OffsetDateTime creationDate;

    private Boolean overdraftEnabled;
}
