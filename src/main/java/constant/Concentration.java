package constant;

import common.SingleIntEnum;

public enum Concentration implements SingleIntEnum {
    /*
    配伍浓度自定义审查维护的是药品与溶媒的适宜浓度范围或溶媒的适宜用量。
    当处方满足所设置的审查条件（包括给药途径、给药单位），并超出相应的浓度范围或溶媒用量时，系统将予以警示。

    1. 高于限制浓度/低于限制溶媒量：禁用。
    2. 高于推荐浓度/高于限制溶媒量/低于限制浓度/低于推荐溶媒量：不推荐。
    3. 低于推荐浓度/高于推荐溶媒量：慎用。
    */

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
