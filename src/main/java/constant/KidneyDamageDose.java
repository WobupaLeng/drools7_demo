package constant;

import common.Dose;
import common.SingleIntEnum;

public enum KidneyDamageDose implements SingleIntEnum {
    /*
    当处方满足所设置的审查条件（包括年龄段、肾损害程度、疾病、给药途径、给药单位、计算方式）
    ，并超出相应的剂量范围、频次范围时，系统将予以警示。

   	1. 低于每次推荐剂量/低于每日推荐剂量/低于推荐频次：慎用。
   	2. 高于每次推荐剂量/高于每日推荐剂量/高于推荐频次：不推荐。
    */
    EACH(1, "每次剂量")
    , DAILY(2, "每日剂量")
    , FREQUENCY(3, "频次")
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
