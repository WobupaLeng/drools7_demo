package constant;

import common.SingleIntEnum;

public enum KidneyDamageDose implements SingleIntEnum {
    ;

    KidneyDamageDose(int value, String name) {
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
