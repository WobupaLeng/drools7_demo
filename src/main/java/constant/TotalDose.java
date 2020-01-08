package constant;

import common.SingleIntEnum;

public enum TotalDose implements SingleIntEnum {
    MULTI_DAY_DOSE(1, "多日剂量")
    , DAILY_LIMIT_DOSE(2, "日限制剂量")
    , CUMULATIVE_DOSE(3, "积累剂量")
    , PRECISE_DOSE(4, "精准剂量")
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
