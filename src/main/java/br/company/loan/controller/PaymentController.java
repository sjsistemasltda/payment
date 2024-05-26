package br.company.loan.controller;

import br.company.loan.Constants;
import br.company.loan.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping(value = Constants.CONTROLLER.PAYMENT.PAY.PATH)
    public ResponseEntity<?> pay(@PathVariable("loanId") Long loanId) {
        return ResponseEntity.ok(paymentService.pay(loanId));
    }
}
