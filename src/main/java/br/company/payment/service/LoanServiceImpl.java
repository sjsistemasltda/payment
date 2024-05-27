package br.company.payment.service;

import br.company.payment.entity.Loan;
import br.company.payment.repository.LoanRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;

    @Override
    public Optional<Loan> get(Long loanId) {
        return loanRepository.findById(loanId);
    }

    @Override
    @Transactional
    public Loan update(Loan loan) {
        return loanRepository.save(loan);
    }
}
