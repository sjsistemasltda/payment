package br.company.payment.service;

import br.company.payment.entity.dto.response.LoanResponseDTO;

public interface PaymentService {
    LoanResponseDTO pay(Long loanId);
}
