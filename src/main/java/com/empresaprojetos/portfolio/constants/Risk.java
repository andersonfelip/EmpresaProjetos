package com.empresaprojetos.portfolio.constants;

public enum Risk {
    LOW_RISK(1),MEDIUM_RISK(2),HIGH_RISK(3);

    public final int value;

    private Risk(int value) {
        this.value = value;
    }
}
