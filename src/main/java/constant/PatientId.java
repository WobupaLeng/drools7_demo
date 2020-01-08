package constant;

import common.SingleIntEnum;

public enum PatientId implements SingleIntEnum {
    PREGNANT_WOMAN(1, "孕妇")
    , PERIOPERATIVE(2,"围术期")
    , OTHER(3, "其他")
    ;

    private final int value;
    private final String name;

    public boolean isPregnantWoman(int value) {
        return value == PREGNANT_WOMAN.value;
    }

    public boolean isPerioperative(int value) {
        return value == PERIOPERATIVE.value;
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
