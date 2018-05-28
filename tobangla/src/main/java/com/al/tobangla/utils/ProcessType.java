package com.al.tobangla.utils;

/**
 * Created by User on 24/1/2018.
 */

public enum ProcessType {

    DATE(0),
    NUMBER(1),
    TIME(2),
    AMOUNT(3),
    ORDINAL_INDICATOR_FOR_DATE(4),
    ORDINAL_INDICATOR_FOR_NUMERIC_ORDER(5),
    ORDINAL_INDICATOR_TODAY(6),

    TODAY(7),
    TIME_NOW(8),
    NOW_DATE_TIME(9),
    DISTANCE(10),
    WEIGHT(11),
    DEFAULT(-1);

    int value;

    ProcessType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
