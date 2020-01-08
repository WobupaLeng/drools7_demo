package constant;

import common.SingleIntEnum;

public enum Gender implements SingleIntEnum {
    MALE(1, "男")
    , FEMALE(2, "女")
    , UNKNOWN(3, "未知")
    ;

    public boolean isMale(int value) {
        return value == MALE.value;
    }

    public boolean isFemale(int value) {
        return value == FEMALE.value;
    }

    public Gender judgeGender(int value) {
        if (value == MALE.value)
            return MALE;
        if (value == FEMALE.value)
            return FEMALE;
        return UNKNOWN;
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
