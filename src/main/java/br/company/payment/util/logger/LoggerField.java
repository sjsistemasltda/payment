package br.company.payment.util.logger;

import lombok.Getter;

@Getter
public enum LoggerField {
    CORRELATION_ID("correlationId"),
    PAYLOAD("payload");

    private final String name;

    LoggerField(String name) {
        this.name = name;
    }

}
