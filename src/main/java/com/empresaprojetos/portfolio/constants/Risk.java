package com.empresaprojetos.portfolio.constants;

public enum Risk {
    LOW_RISK("1"),MEDIUM_RISK("2"),HIGH_RISK("3");

    public final String value;

    Risk(String value) {
        this.value = value;
    }

    public static Risk findByName(String name){
        for(Risk v : values()){
            if(v.value.equals(name)){
                return v;
            }
        }
        return null;
    }
}
