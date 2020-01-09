package constant;

import common.SingleIntEnum;

public enum Gender implements SingleIntEnum {
    MALE(1, "男")
    , FEMALE(2, "女")
    , UNKNOWN(3, "未知")
    ;

    public boolean isMale() {
        return this == MALE;
    }

    public boolean isFemale() {
        return this == FEMALE;
    }

    private final int value;
    private final String name;

    Gender(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
