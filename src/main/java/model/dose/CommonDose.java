package model.dose;

import constant.FrequencyUnit;
import lombok.Data;

@Data
public class CommonDose {
    private int eachDose;                   //每次剂量
    private int dailyDose;                  //每日剂量
    private int frequency;                  //频率次数
    private FrequencyUnit frequencyUnit;    //频率单位
    private int medicationDays;             //用药天数

    public int getDailyDose(FrequencyUnit unit) {
        if (unit.canEveryMinute()) {
            return eachDose * 3600 * 24;
        }
        if (unit.canPerHour()) {
            return eachDose * 24;
        }
        if (unit.canEveryDay()) {
            return eachDose;
        }
        if (unit.canPerMonth()) {
            return eachDose / 30;
        }
        if (unit.canPerYear()) {
            return eachDose / 12 / 30;
        }
        return -1;
    }
}
