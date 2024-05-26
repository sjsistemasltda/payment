package br.company.loan.service;

import br.company.loan.entity.Loan;

import java.util.Optional;

public interface LoanService {
    Optional<Loan> get(Long loanId);

    Loan update(Loan loan);
}
