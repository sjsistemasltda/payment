package br.company.loan.service;

import br.company.loan.controller.exception.LoanNotFoundException;
import br.company.loan.entity.Loan;
import br.company.loan.entity.dto.response.LoanResponseDTO;
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
