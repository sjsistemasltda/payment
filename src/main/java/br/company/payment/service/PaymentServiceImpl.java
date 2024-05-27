package br.company.payment.service;

import br.company.payment.controller.exception.LoanNotFoundException;
import br.company.payment.entity.Loan;
import br.company.payment.entity.dto.response.LoanResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final LoanService loanService;

    private final static String PAYMENT_STATUS_PAID = "PAID";

    @Override
    public LoanResponseDTO pay(Long loanId) {
        Loan loan = loanService.get(loanId).orElseThrow(() -> new LoanNotFoundException("Loan not found"));
        loan.setPaymentStatus(PAYMENT_STATUS_PAID);
        return LoanResponseDTO.convert(loanService.update(loan));
    }
}
