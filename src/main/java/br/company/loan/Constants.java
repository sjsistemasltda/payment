package br.company.loan;

public interface Constants {
    String PATH_SEPARATOR = "/";
    interface CONTROLLER {
        String VERSION = "v1";

        interface PAYMENT {
            String NAME = "payments";
            String PATH = PATH_SEPARATOR + VERSION + PATH_SEPARATOR + NAME;
            String SLUG = "loanId";
            String PATH_SLUG = PATH_SEPARATOR + "{" + SLUG + "}";

            interface PAY {
                String NAME = "pay";
                String PATH = PAYMENT.PATH + PAYMENT.PATH_SLUG + PATH_SEPARATOR + NAME;
            }
        }
    }

    interface RDS {
        String SCHEMA = "bank";
        String DOT = ".";

        interface TABLE {
            interface LOAN {
                String NAME = "loan";
                String SEQ = SCHEMA + DOT + NAME + "_seq";
            }

            interface PERSON {
                String NAME = "person";
                String SEQ = SCHEMA + DOT + NAME + "_seq";
            }
        }
    }
}
