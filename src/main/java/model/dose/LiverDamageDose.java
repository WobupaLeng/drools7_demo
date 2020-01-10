package model.dose;

import constant.FrequencyUnit;
import lombok.Data;

@Data
public class LiverDamageDose {
    private int eachDose;                   //每次剂量
    private int dailyDose;                  //每日剂量
    private int frequency;                  //频率次数
    private FrequencyUnit frequencyUnit;    //频率单位

    public static LiverDamageDose create(FrequencyUnit unit, int eachDose, int frequency) {
        LiverDamageDose dose = new LiverDamageDose();
        dose.dailyDose = unit.getDailyDose(frequency, eachDose);
        dose.eachDose = eachDose;
        dose.frequency = frequency;
        dose.frequencyUnit = unit;
        return dose;
    }
}
