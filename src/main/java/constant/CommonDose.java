package constant;

import common.SingleIntEnum;

public enum CommonDose implements SingleIntEnum {
    /*1. 低于每次推荐剂量/低于每日推荐剂量/低于推荐频次/低于推荐用药天数：慎用。
      2. 高于每次推荐剂量/高于每日推荐剂量/高于推荐频次/高于推荐用药天数：不推荐。

      3. 高于每次限制量/高于每日限制量：禁用。
      4. 高于最大用药天数：禁用。
      5. 高于疗程总剂量：禁用。

      单日 = 每次 * 频次
      总量 = 单日 * 天数
    */

    Each(1, "每次剂量")
    ,daily(2, "每日剂量")
    ,frequency(3,"频次")
    ,Medication_days(4, "用药天数")
    ;

    CommonDose(int value, String name) {
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
