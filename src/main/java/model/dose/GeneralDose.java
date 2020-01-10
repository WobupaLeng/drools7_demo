package model.dose;

import constant.FrequencyUnit;
import lombok.Data;

@Data
public class GeneralDose {
    private int eachDose;                   //每次剂量
    private int dailyDose;                  //每日剂量
    private int frequency;                  //频率次数
    private FrequencyUnit frequencyUnit;    //频率单位
    private int medicationDays;             //用药天数

    private int multiDayDose;      //多日剂量
    private int dailyLimitDose;    //日限制剂量
    private int cumulativeDose;    //积累剂量

    public static GeneralDose create(FrequencyUnit unit, int eachDose, int frequency, int medicationDays) {
        GeneralDose dose = new GeneralDose();
        dose.dailyDose = unit.getDailyDose(frequency, eachDose);
        dose.eachDose = eachDose;
        dose.frequency = frequency;
        dose.frequencyUnit = unit;
        dose.medicationDays = medicationDays;

        if (medicationDays <= 0) {
            dose.multiDayDose = 0;
            dose.dailyLimitDose = 0;
            dose.cumulativeDose = 0;
        } else {
            dose.multiDayDose = dose.dailyDose * dose.medicationDays;
            dose.dailyLimitDose = dose.dailyDose;
            dose.cumulativeDose = dose.dailyDose * dose.medicationDays;
        }
        return dose;
    }
}
