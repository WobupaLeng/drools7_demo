package constant;

import common.SingleIntEnum;

public enum FrequencyUnit implements SingleIntEnum {
    EVERY_MINUTE(1, "每分钟") {
        @Override
        public int getDailyDose(int frequency, int eachDose) {
            return eachDose * 60 * 24 * frequency;
        }
    }, PER_HOUR(2, "每小时") {
        @Override
        public int getDailyDose(int frequency, int eachDose) {
            return eachDose * 24 * frequency;
        }
    }, EVERY_DAY(3, "每天") {
        @Override
        public int getDailyDose(int frequency, int eachDose) {
            return eachDose * frequency;
        }
    }, PER_MONTH(4, "每月") {
        @Override
        public int getDailyDose(int frequency, int eachDose) {
            return eachDose / 30 * frequency;
        }
    }, PER_YEAR(5, "每年") {
        @Override
        public int getDailyDose(int frequency, int eachDose) {
            return eachDose / 12 / 30 * frequency;
        }
    }, UNKNOWN(-1, "未知") {
        @Override
        public int getDailyDose(int frequency, int eachDose) {
            return -1;
        }
    };

    private final String name;
    private final int value;

    FrequencyUnit(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public abstract int getDailyDose(int frequency, int eachDose);

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
