package constant;

import common.SingleIntEnum;

public enum FrequencyUnit implements SingleIntEnum {
    EVERY_MINUTE(1,"每分钟")
    , PER_HOUR(2, "每小时")
    , EVERY_DAY(3, "每天")
    , PER_MONTH(4, "每月")
    , PER_YEAR(5, "每年")
    , UNKNOWN(-1, "未知")
    ;

    private final String name;
    private final int value;

    FrequencyUnit(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public boolean canEveryMinute() {
        return this == EVERY_MINUTE;
    }

    public boolean canPerHour() {
        return this == PER_HOUR;
    }

    public boolean canEveryDay() {
        return this == EVERY_DAY;
    }

    public boolean canPerMonth() {
        return this == PER_MONTH;
    }

    public boolean canPerYear() {
        return this == PER_YEAR;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
