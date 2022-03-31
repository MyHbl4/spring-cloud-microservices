package deposit.service;

import com.javastart.deposit.controller.dto.DepositResponseDTO;
import com.javastart.deposit.entity.Deposit;
import com.javastart.deposit.exception.DepositServiceException;
import com.javastart.deposit.repository.DepositRepository;
import com.javastart.deposit.rest.AccountResponseDTO;
import com.javastart.deposit.rest.AccountServiceClient;
import com.javastart.deposit.rest.BillResponseDTO;
import com.javastart.deposit.rest.BillServiceClient;
import com.javastart.deposit.service.DepositService;
import deposit.utils.ObjectForTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RunWith(MockitoJUnitRunner.class)
public class DepositServiceTest {


    @Mock
    private DepositRepository depositRepository;

    @Mock
    private AccountServiceClient accountServiceClient;

    @Mock
    private BillServiceClient billServiceClient;

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private DepositService depositService;

    @Test
    public void depositServiceTest_withBillId() {
        ObjectForTest responseDTO = new ObjectForTest();
        BillResponseDTO billResponseDTO = responseDTO.createBillResponseDTO();
        AccountResponseDTO accountResponseDTO = responseDTO.createAccountResponseDTO();
        Mockito.when(billServiceClient.getBillById(ArgumentMatchers.anyLong()))
            .thenReturn(billResponseDTO);
        Mockito.when(accountServiceClient.getAccountById(ArgumentMatchers.anyLong()))
            .thenReturn(accountResponseDTO);
        DepositResponseDTO deposit = depositService.deposit(null, 1L, BigDecimal.valueOf(1000));
        Assertions.assertThat(deposit.getEmail()).isEqualTo("moon@gmail.com");

    }

    @Test(expected = DepositServiceException.class)
    public void depositServiceTest_withException() {
        depositService.deposit(null, null, BigDecimal.valueOf(1000));
    }

    @Test
    public void getDepositsByEmail() {
        ObjectForTest objectForTest = new ObjectForTest();
        Deposit deposit = objectForTest.createDeposit();
        List<Deposit> deposits = new ArrayList<>();
        deposits.add(deposit);
        Mockito.when(depositRepository.findDepositsByEmail("moon@gmail.com"))
            .thenReturn(deposits);
        List<Deposit> depositsByEmail = depositService.getDepositsByEmail("moon@gmail.com");
        Assertions.assertThat(depositsByEmail.size()).isEqualTo(1);
        Assertions.assertThat(depositsByEmail.get(0).getEmail()).isEqualTo("moon@gmail.com");
    }

    @Test
    public void getDepositsByEmail_withEmptyList() {
        Mockito.when(depositRepository.findDepositsByEmail(ArgumentMatchers.anyString()))
            .thenReturn(new ArrayList<>());
        List<Deposit> depositsByEmail = depositService.getDepositsByEmail("mmm@gmail.com");
        Assertions.assertThat(depositsByEmail.size()).isEqualTo(0);
    }

    @Test
    public void getDepositsByEmail_withNull() {
        Mockito.when(depositRepository.findDepositsByEmail(ArgumentMatchers.anyString()))
            .thenReturn(null);
        List<Deposit> depositsByEmail = depositService.getDepositsByEmail("mmm@gmail.com");
        Assertions.assertThat(depositsByEmail).isNull();
    }
}
