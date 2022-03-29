package com.javastart.bill.repository;

import com.javastart.bill.entity.Bill;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Long> {

    List<Bill> getBillsByAccountId(Long accountId);
}
