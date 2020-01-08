package constant;

import common.SingleIntEnum;

public enum Concentration implements SingleIntEnum {
    DRUG(1, "药品")
    , SOLVENT(2, "溶媒")
    ;

    Concentration(int value, String name) {
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
