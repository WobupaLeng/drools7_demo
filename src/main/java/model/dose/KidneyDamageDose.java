package model.dose;

import constant.FrequencyUnit;
import lombok.Data;

@Data
public class KidneyDamageDose {
    private int eachDose;                   //每次剂量
    private int dailyDose;                  //每日剂量
    private int frequency;                  //频率次数
    private FrequencyUnit frequencyUnit;    //频率单位

    public static KidneyDamageDose create(FrequencyUnit unit, int eachDose, int frequency) {
        KidneyDamageDose dose = new KidneyDamageDose();
        dose.dailyDose = unit.getDailyDose(frequency, eachDose);
        dose.eachDose = eachDose;
        dose.frequency = frequency;
        dose.frequencyUnit = unit;
        return dose;
    }
}
