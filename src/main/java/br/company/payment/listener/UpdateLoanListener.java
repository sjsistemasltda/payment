package br.company.payment.listener;

import br.company.payment.entity.dto.sqs.LoanReceiverDTO;
import br.company.payment.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateLoanListener {
    private final PaymentService paymentService;

    @SqsListener(value = "process-payment")
    public void process(String payload) throws JsonProcessingException {
        LoanReceiverDTO loan = new ObjectMapper().readValue(payload, LoanReceiverDTO.class);
        paymentService.pay(loan.getId());
    }

}
