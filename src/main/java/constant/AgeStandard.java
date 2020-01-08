package constant;

import common.SingleIntEnum;

public enum AgeStandard implements SingleIntEnum {
    CHILD(1, "儿童")
    ,ELDERLY(2, "老年人")
    ,ADULT(3,"成人")
    ;

    private final String name;
    private final int value;

    public AgeStandard ageJudge(int age) {
        if (age <= 14)
            return AgeStandard.CHILD;
        if (age >= 65)
            return AgeStandard.ELDERLY;
        return ADULT;
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
