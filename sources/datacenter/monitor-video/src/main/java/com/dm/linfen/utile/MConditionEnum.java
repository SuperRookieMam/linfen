package com.dm.linfen.utile;

public enum MConditionEnum {
    EQ(1,"eq"),
    NOT_EQ(2,"notEq"),
    LIKE(3,"like"),
    NOT_LIKE(4,"notLike"),
    LT(5,"lt"),
    LE(6,"le"),
    GT(7,"gt"),
    GE(8,"ge"),
    IN(9,"in"),
    NOT_IN(10,"notIn"),
    IS_NULL(11,"isNull"),
    NOTNULL(12,"notNull"),
    IS_MEMBER(13,"isMember"),
    IS_NOT_MEMBER(14,"isNotMember");

    private int code;

    private String value;

    MConditionEnum(int code, String value){
        this.code = code;
        this.value = value;
    }

    public static String valueOf(int code) {
        MConditionEnum[] resultEnums = values();
        for(int i = 0; i < resultEnums.length; ++i) {
            MConditionEnum resultEnum = resultEnums[i];
            if(resultEnum.code == code) {
                return resultEnum.value;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }


}
