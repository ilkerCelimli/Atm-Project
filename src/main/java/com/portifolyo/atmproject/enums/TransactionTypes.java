package com.portifolyo.atmproject.enums;

public enum TransactionTypes {

    SEND("SEND"),
    ACCEPT("ACCEPT");

    public final String text;
    TransactionTypes(String text) {
        this.text = text;
    }
}
