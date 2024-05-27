package br.company.payment.service;

import br.company.payment.entity.Loan;

import java.util.Optional;

public interface LoanService {
    Optional<Loan> get(Long loanId);

    Loan update(Loan loan);
}
