package common;

public enum  Dose implements SingleIntEnum {
    /*
    commonDose
        1. 低于每次推荐剂量/低于每日推荐剂量/低于推荐频次/低于推荐用药天数：慎用。
        2. 高于每次推荐剂量/高于每日推荐剂量/高于推荐频次/高于推荐用药天数：不推荐。

        3. 高于每次限制量/高于每日限制量：禁用。
        4. 高于最大用药天数：禁用。
        5. 高于疗程总剂量：禁用。
        总量 = 单日（每次 * 频次） * 天数

    concentration
    配伍浓度自定义审查维护的是药品与溶媒的适宜浓度范围或溶媒的适宜用量。
    当处方满足所设置的审查条件（包括给药途径、给药单位），并超出相应的浓度范围或溶媒用量时，系统将予以警示。
        1. 高于限制浓度/低于限制溶媒量：禁用。
        2. 高于推荐浓度/高于限制溶媒量/低于限制浓度/低于推荐溶媒量：不推荐。
        3. 低于推荐浓度/高于推荐溶媒量：慎用。

    肝、肾 损害剂量
    当处方满足所设置的审查条件（包括年龄段、肾损害程度、疾病、给药途径、给药单位、计算方式），
    并超出相应的剂量范围、频次范围时，系统将予以警示。
   	    1. 低于每次推荐剂量/低于每日推荐剂量/低于推荐频次：慎用。
   	    2. 高于每次推荐剂量/高于每日推荐剂量/高于推荐频次：不推荐。
    */

    ;

    Dose(int value, String name) {
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
