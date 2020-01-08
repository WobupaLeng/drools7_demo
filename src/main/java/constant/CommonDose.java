package constant;

import common.SingleIntEnum;

public enum CommonDose implements SingleIntEnum {
    EACH(1, "每次剂量")
    , DAILY(2, "每日剂量")
    , FREQUENCY(3, "频次")
    , MEDICATION_DAYS(4, "用药天数")
    ;

    CommonDose(int value, String name) {
        this.value = value;
        this.name = name;
    }

    private final int value;
    private final String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
