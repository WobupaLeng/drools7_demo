package constant;

import common.SingleIntEnum;

public enum PatientId implements SingleIntEnum {
    PREGNANT_WOMAN(1, "孕妇")
    , PERIOPERATIVE(2,"围术期")
    , OTHER(3, "其他")
    ;

    private final int value;
    private final String name;

    public boolean isPregnantWoman() {
        return this == PREGNANT_WOMAN;
    }

    public boolean isPerioperative() {
        return this == PERIOPERATIVE;
    }

    PatientId(int value, String name) {
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
