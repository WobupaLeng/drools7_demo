package constant;

import common.SingleIntEnum;

public enum TotalDose implements SingleIntEnum {
    Multi_day_dosage(1, "多日用量")
    , Daily_limit(2, "日限制量")
    , Cumulative_dose(3, "积累剂量")
    , Precise_dose(4, "精准剂量")
    ;

    TotalDose(int value, String name) {
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
