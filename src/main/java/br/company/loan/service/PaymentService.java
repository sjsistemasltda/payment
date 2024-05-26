package br.company.loan.service;

import br.company.loan.entity.dto.response.LoanResponseDTO;

public interface PaymentService {
    LoanResponseDTO pay(Long loanId);
}
