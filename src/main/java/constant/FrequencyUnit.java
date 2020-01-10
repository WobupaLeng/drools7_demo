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

    public int getDailyDose(int frequency, int eachDose) {
        int dailyDose = -1;
        if (this == EVERY_MINUTE) {
            dailyDose = (eachDose * 3600 * 24 * frequency);
        }
        if (this == PER_HOUR) {
            dailyDose = (eachDose * 24 * frequency);
        }
        if (this == EVERY_DAY) {
            dailyDose = (eachDose * frequency);
        }
        if (this == PER_MONTH) {
            dailyDose = (eachDose / 30 * frequency);
        }
        if (this == PER_YEAR) {
            dailyDose = (eachDose / 12 / 30 * frequency);
        }
        return dailyDose;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
