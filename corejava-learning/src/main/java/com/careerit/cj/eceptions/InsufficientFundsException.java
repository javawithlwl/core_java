package com.careerit.cj.eceptions;

public class InsufficientFundsException extends  RuntimeException {
        public InsufficientFundsException(String message){
            super(message);
        }
}
