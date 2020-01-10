package constant;

import common.SingleIntEnum;

public enum AgeStandard implements SingleIntEnum {
    CHILD(1, "儿童")
    , ADULT(2, "成人")
    , ELDERLY(3, "老年人")
    ;

    private final String name;
    private final int value;

    public static AgeStandard ageJudge(int age) {
        if (age <= 14)
            return AgeStandard.CHILD;
        if (age >= 65)
            return AgeStandard.ELDERLY;
        return ADULT;
    }

    public boolean isChild() {
        return this == AgeStandard.CHILD;
    }

    public boolean isAdult() {
        return this == AgeStandard.ADULT;
    }

    public boolean isElderly() {
        return this == AgeStandard.ELDERLY;
    }

    AgeStandard(int value, String name) {
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
