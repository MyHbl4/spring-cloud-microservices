package deposit.utils;


import com.javastart.deposit.entity.Deposit;
import com.javastart.deposit.rest.AccountResponseDTO;
import com.javastart.deposit.rest.BillResponseDTO;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Arrays;

public class ObjectForTest {

    public AccountResponseDTO createAccountResponseDTO() {
        AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
        accountResponseDTO.setAccountId(1L);
        accountResponseDTO.setName("name");
        accountResponseDTO.setEmail("moon@gmail.com");
        accountResponseDTO.setCreationDate(OffsetDateTime.now());
        accountResponseDTO.setPhone("+375441234567");
        accountResponseDTO.setBills(Arrays.asList(1L, 2L, 3L));

        return accountResponseDTO;
    }

    public BillResponseDTO createBillResponseDTO() {
        BillResponseDTO billResponseDTO = new BillResponseDTO();
        billResponseDTO.setBillId(1L);
        billResponseDTO.setAccountId(1L);
        billResponseDTO.setAmount(BigDecimal.valueOf(1000));
        billResponseDTO.setCreationDate(OffsetDateTime.now());
        billResponseDTO.setIsDefault(true);
        billResponseDTO.setOverdraftEnabled(true);

        return billResponseDTO;
    }

    public Deposit createDeposit() {
        Deposit deposit = new Deposit();
        deposit.setDepositId(1L);
        deposit.setBillId(1L);
        deposit.setAmount(BigDecimal.valueOf(1000));
        deposit.setCreateDate(OffsetDateTime.now());
        deposit.setEmail("moon@gmail.com");

        return deposit;
    }
}
