package br.company.payment.service;

import br.company.payment.controller.exception.LoanNotFoundException;
import br.company.payment.entity.Loan;
import br.company.payment.entity.Person;
import br.company.payment.entity.dto.response.LoanResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {

    @Mock
    private LoanService loanService;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    private Loan loan;

    @BeforeEach
    public void setUp() {
        Person person = new Person();
        person.setId(1L);
        person.setName("John Doe");

        loan = new Loan();
        loan.setId(1L);
        loan.setAmount(new BigDecimal("1000.00"));
        loan.setInvoiceQuantity(12);
        loan.setPaymentStatus("WAITING_PAYMENT");
        loan.setPerson(person);
        loan.setCreatedAt(LocalDate.now());
    }

    @Test
    public void testPaySuccess() {
        when(loanService.get(any())).thenReturn(Optional.of(loan));
        when(loanService.update(any())).thenReturn(loan);

        LoanResponseDTO response = paymentService.pay(1L);

        assertEquals("PAID", loan.getPaymentStatus());
        assertEquals(loan.getId(), response.getId());
        verify(loanService, times(1)).get(any(Long.class));
        verify(loanService, times(1)).update(any(Loan.class));
    }

    @Test
    public void testPayLoanNotFound() {
        when(loanService.get(any(Long.class))).thenReturn(Optional.empty());

        Exception exception = assertThrows(LoanNotFoundException.class, () -> {
            paymentService.pay(1L);
        });

        assertEquals("Loan not found", exception.getMessage());
        verify(loanService, times(0)).update(any(Loan.class));
    }
}