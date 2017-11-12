package com.pinet.app.config;

/**
 * Created by bijesh on 10/28/2017.
 */
public class PokharaInternetException extends Exception {
   

    public PokharaInternetException(String message) {
        super(message);
    }

    public PokharaInternetException(String message, Throwable cause) {
        super(message, cause);
    }

    public PokharaInternetException(Throwable cause) {
        super(cause);
    }

    public PokharaInternetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

