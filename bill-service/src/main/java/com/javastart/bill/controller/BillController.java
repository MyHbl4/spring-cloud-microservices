package com.javastart.bill.controller;

import com.javastart.bill.controller.dto.BillRequestDTO;
import com.javastart.bill.controller.dto.BillResponseDTO;
import com.javastart.bill.service.BillService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/{billId}")
    public BillResponseDTO getBill(@PathVariable Long billId) {
        return new BillResponseDTO(billService.getBillById(billId));
    }

    @PostMapping("/")
    public Long createBill(@RequestBody BillRequestDTO billRequestDTO) {
        return billService.createBill(billRequestDTO.getAccountId(), billRequestDTO.getAmount(),
            billRequestDTO.getIsDefault(), billRequestDTO.getOverdraftEnabled());
    }

    @PutMapping("/{billId}")
    public BillResponseDTO updateBill(@PathVariable Long billId,
        @RequestBody BillRequestDTO billRequestDTO) {
        return new BillResponseDTO(billService.updateBill(billId, billRequestDTO.getAccountId(),
            billRequestDTO.getAmount(), billRequestDTO.getIsDefault(),
            billRequestDTO.getOverdraftEnabled()));
    }

    @DeleteMapping("/{billId}")
    public BillResponseDTO deleteBill(@PathVariable Long billId) {
        return new BillResponseDTO(billService.deleteBill(billId));
    }

    @GetMapping("/account/{accountId}")
    public List<BillResponseDTO> getBillsByAccountId(@PathVariable Long accountId) {
        return billService.getBillsByAccountId(accountId).stream().map(BillResponseDTO::new)
            .collect(
                Collectors.toList());
    }
}
