package com.javastart.deposit.repository;


import com.javastart.deposit.entity.Deposit;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DepositRepository extends CrudRepository<Deposit, Long> {

    List<Deposit> findDepositsByEmail(String email);
}
