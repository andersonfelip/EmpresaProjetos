package com.empresaprojetos.portfolio.constants;

public enum Status {
    UNDER_REVIEW("1"),ANALYSIS_PERFORMED("2"),APPROVED_ANALYSIS("3"),STARTED("4"),PLANNED("5"),IN_PROGRESS("6"),CLOSED("7"),CANCELED("8");

    public final String value;

    Status(String value) {
        this.value = value;
    }

    public static Status findByName(String name){
        for(Status v : values()){
            if(v.value.equals(name)){
                return v;
            }
        }
        return null;
    }
}
